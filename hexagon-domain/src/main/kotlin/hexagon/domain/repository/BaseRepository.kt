package hexagon.domain.repository

import hexagon.domain.entity.BaseEntity
import hexagon.domain.exception.OptimisticConcurrentException

interface BaseRepository<T : BaseEntity?> {
  @Throws(OptimisticConcurrentException::class) fun persist(entity: T)

  fun findByIds(ids: List<Long>): List<T>

  fun find(id: Long): T?

  fun delete(id: Long)
}
