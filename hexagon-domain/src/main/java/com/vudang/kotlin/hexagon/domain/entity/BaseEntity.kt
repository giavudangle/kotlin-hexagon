package com.vudang.kotlin.hexagon.domain.entity

import com.vudang.kotlin.hexagon.domain.event.BaseEvent
import java.time.Instant

abstract class BaseEntity {
  var id: Long = 0
  var createdAt: Long = Instant.now().toEpochMilli()
  var updatedAt: Long = Instant.now().toEpochMilli()
  var version = 0
  var events = mutableListOf<BaseEvent>()

  open fun flushEvents(): List<BaseEvent> {
    val flushableEvents = events
    events = mutableListOf<BaseEvent>()

    return flushableEvents
  }

  fun updateVersion() {
    version.plus(1)
  }
}


