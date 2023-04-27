package hexagon.adapter.eventbus

import hexagon.adapter.event.BaseIntegrationEvent

interface IntegrationEventPublisherInterface {
  fun publish(event: BaseIntegrationEvent)
}
