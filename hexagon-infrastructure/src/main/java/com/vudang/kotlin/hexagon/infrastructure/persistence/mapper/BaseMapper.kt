package com.vudang.kotlin.hexagon.infrastructure.persistence.mapper

import com.vudang.kotlin.hexagon.domain.entity.BaseEntity
import java.util.*

interface BaseMapper<T : BaseEntity> {
  fun insert(entity: T)

  fun update(entity: T): Int

  fun find(id: Long): T?

  fun delete(id: Long)

  fun findByIds(ids: List<Long>): List<T>
}
