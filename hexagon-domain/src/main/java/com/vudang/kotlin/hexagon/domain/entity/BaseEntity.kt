package com.vudang.kotlin.hexagon.domain.entity

import java.time.Instant

abstract class BaseEntity {
  var id: Long = 0
  var createdAt: Long = Instant.now().toEpochMilli()
  var updatedAt: Long = Instant.now().toEpochMilli()
  protected var version = 0
  private var events = mutableListOf<Any>()

  fun flushEvents(): List<Any> {
    val flushableEvents = events
    events = mutableListOf<Any>()

    return flushableEvents
  }
}
