package com.vudang.kotlin.hexagon.domain.repository

import com.vudang.kotlin.hexagon.domain.entity.BaseEntity
import com.vudang.kotlin.hexagon.domain.exception.OptimisticConcurrentException

interface BaseRepository<T : BaseEntity?> {
  @Throws(OptimisticConcurrentException::class) fun persist(entity: T)

  fun findByIds(ids: List<Long>): List<T>

  fun find(id: Long): T?

  fun delete(id: Long)
}
