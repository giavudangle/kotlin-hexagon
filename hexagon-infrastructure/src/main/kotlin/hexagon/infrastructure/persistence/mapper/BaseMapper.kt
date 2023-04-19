package hexagon.infrastructure.persistence.mapper

import hexagon.domain.entity.BaseEntity

interface BaseMapper<T : BaseEntity> {
  fun insert(entity: T)

  fun update(entity: T): Int

  fun find(id: Long): T?

  fun delete(id: Long)

  fun findByIds(ids: List<Long>): List<T>
}
