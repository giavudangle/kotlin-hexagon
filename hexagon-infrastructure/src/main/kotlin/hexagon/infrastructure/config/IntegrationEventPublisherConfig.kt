package hexagon.infrastructure.config

import hexagon.adapter.eventbus.IntegrationEventPublisherInterface
import hexagon.infrastructure.eventbus.IntegrationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class IntegrationEventPublisherConfig {
  @Bean
  open fun integrationEventPublisher(): IntegrationEventPublisherInterface {
    return IntegrationEventPublisher()
  }
}
