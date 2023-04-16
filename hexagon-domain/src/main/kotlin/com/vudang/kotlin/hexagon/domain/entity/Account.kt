package com.vudang.kotlin.hexagon.domain.entity

import com.vudang.kotlin.hexagon.domain.event.AccountCreatedEvent

import com.vudang.kotlin.hexagon.domain.event.BaseEvent




open class Account(val name: String, val email: String, val password: String) : BaseEntity() {
  companion object {}

  open fun buildCreatedEvent() {
    events.add(AccountCreatedEvent(this))
  }

  override fun flushEvents() : List<BaseEvent> {
    return super.flushEvents()
  }
}


