package com.vudang.kotlin.hexagon.domain.entity

import java.time.Instant

abstract class BaseEntity {
  var id: Long = 0
  var updatedAt: Instant = Instant.now()
  var createdAt: Instant = Instant.now()
  protected var version = 0
  private var events = mutableListOf<Any>()

  fun flushEvents(): List<Any> {
    val flushableEvents = events
    events = mutableListOf<Any>()

    return flushableEvents
  }
}
