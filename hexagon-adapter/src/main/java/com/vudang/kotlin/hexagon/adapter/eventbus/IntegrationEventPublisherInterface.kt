package com.vudang.kotlin.hexagon.adapter.eventbus

import com.vudang.kotlin.hexagon.adapter.event.BaseIntegrationEvent

interface IntegrationEventPublisherInterface {
  fun publish(event: BaseIntegrationEvent)
}
