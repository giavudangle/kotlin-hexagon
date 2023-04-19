package hexagon.infrastructure.repository

import hexagon.domain.entity.BaseEntity
import hexagon.domain.exception.OptimisticConcurrentException
import hexagon.domain.repository.BaseRepository
import hexagon.infrastructure.persistence.mapper.BaseMapper
import java.time.Instant

abstract class BaseRepositoryImpl<E : BaseEntity, M : BaseMapper<E>>(protected open val mapper: M) :
  BaseRepository<E> {

  @Throws(OptimisticConcurrentException::class)
  override fun persist(entity: E) {
    if (entity.id == 0L) {
      entity.createdAt = Instant.now().toEpochMilli()
      entity.updatedAt = Instant.now().toEpochMilli()

      mapper.insert(entity)
    } else {
      entity.updatedAt = Instant.now().toEpochMilli()

      val changed = mapper.update(entity)
      if (changed < 1) {
        throw OptimisticConcurrentException()
      }
    }
  }

  override fun findByIds(ids: List<Long>): List<E> {
    if (ids.isEmpty()) return listOf()
    return mapper.findByIds(ids)
  }

  override fun find(id: Long): E? {
    return mapper.find(id)
  }

  override fun delete(id: Long) {
    return mapper.delete(id)
  }
}
