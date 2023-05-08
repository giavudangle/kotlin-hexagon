package hexagon.adapter.eventbus

import hexagon.adapter.event.BaseIntegrationEvent
import hexagon.domain.EventDispatcherInterface
import hexagon.domain.event.BaseDomainEvent
import hexagon.domain.event.BaseEvent
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
