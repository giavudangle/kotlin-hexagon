package hexagon.infrastructure.eventbus

import hexagon.adapter.event.BaseIntegrationEvent
import hexagon.adapter.eventbus.IntegrationEventPublisherInterface

class IntegrationEventPublisher() : IntegrationEventPublisherInterface {
  override fun publish(event: BaseIntegrationEvent) {
    // TODO("Implement integration event publisher for ex: publish to queue")
  }
}
