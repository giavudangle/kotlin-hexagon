package com.vudang.kotlin.hexagon.adapter.eventbus

import com.vudang.kotlin.hexagon.adapter.event.BaseIntegrationEvent
import com.vudang.kotlin.hexagon.domain.EventDispatcherInterface
import com.vudang.kotlin.hexagon.domain.event.BaseDomainEvent
import com.vudang.kotlin.hexagon.domain.event.BaseEvent
import org.axonframework.eventhandling.EventBus

class EventDispatcher(private val eventBus: EventBus) : EventDispatcherInterface {
  override fun dispatch(events: List<BaseEvent?>) {
    for (event in events) dispatch(event)
  }

  override fun <T : BaseEvent?> dispatch(event: T) {
    if (event is BaseDomainEvent) {
      eventBus.publish(DomainEventMessage(event))
    }

    if (event is BaseIntegrationEvent) {
      eventBus.publish(IntegrationEventMessage(event))
    }
  }
}
