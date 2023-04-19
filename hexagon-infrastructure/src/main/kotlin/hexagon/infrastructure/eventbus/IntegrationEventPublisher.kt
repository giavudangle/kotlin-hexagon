package hexagon.infrastructure.eventbus

import hexagon.adapter.eventbus.IntegrationEventPublisherInterface

class IntegrationEventPublisher() : IntegrationEventPublisherInterface {
  override fun publish(event: hexagon.adapter.event.BaseIntegrationEvent) {
    // TODO("Implement integration event publisher for ex: publish to queue")
  }
}
