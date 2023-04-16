package com.vudang.kotlin.hexagon.infrastructure.eventbus

import com.vudang.kotlin.hexagon.adapter.event.BaseIntegrationEvent
import com.vudang.kotlin.hexagon.adapter.eventbus.IntegrationEventPublisherInterface

class IntegrationEventPublisher() : IntegrationEventPublisherInterface {
    override fun publish(event: BaseIntegrationEvent) {
        // TODO("Implement integration event publisher for ex: publish to queue")
    }
}