package com.vudang.kotlin.hexagon.infrastructure.config

import com.vudang.kotlin.hexagon.adapter.eventbus.IntegrationEventPublisherInterface
import com.vudang.kotlin.hexagon.infrastructure.eventbus.IntegrationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class IntegrationEventPublisherConfig {
    @Bean
    open fun integrationEventPublisher() : IntegrationEventPublisherInterface {
        return IntegrationEventPublisher()
    }

}