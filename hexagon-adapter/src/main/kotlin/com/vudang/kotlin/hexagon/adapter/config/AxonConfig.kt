package com.vudang.kotlin.hexagon.adapter.config

import com.vudang.kotlin.hexagon.adapter.eventbus.EventDispatcher
import com.vudang.kotlin.hexagon.adapter.eventbus.HexagonEventBus
import com.vudang.kotlin.hexagon.adapter.eventbus.IntegrationEventPublisherInterface
import com.vudang.kotlin.hexagon.domain.EventDispatcherInterface
import javax.sql.DataSource
import org.axonframework.common.jdbc.ConnectionProvider
import org.axonframework.common.jdbc.UnitOfWorkAwareConnectionProviderWrapper
import org.axonframework.eventhandling.EventBus
import org.axonframework.eventhandling.SimpleEventBus
import org.axonframework.queryhandling.LoggingQueryInvocationErrorHandler
import org.axonframework.queryhandling.QueryBus
import org.axonframework.queryhandling.SimpleQueryBus
import org.axonframework.serialization.Serializer
import org.axonframework.serialization.json.JacksonSerializer
import org.axonframework.spring.jdbc.SpringDataSourceConnectionProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
open class AxonConfig(private val integrationEventPublisher: IntegrationEventPublisherInterface) {
  @Bean
  @Primary
  open fun jacksonSerializer(): Serializer {
    return JacksonSerializer.defaultSerializer()
  }

  @Bean
  open fun hexagonEventBus() : HexagonEventBus{
    return HexagonEventBus(integrationEventPublisher)
  }
  @Bean
  open fun queryBus(): QueryBus {
    return SimpleQueryBus.builder()
      .errorHandler(LoggingQueryInvocationErrorHandler.builder().build())
      .build()
  }

  @Bean
  open fun jdbcConnectionProvider(dataSource: DataSource): ConnectionProvider {
    return UnitOfWorkAwareConnectionProviderWrapper(SpringDataSourceConnectionProvider(dataSource))
  }

  @Bean
  open fun eventDispatcher(eventBus: EventBus): EventDispatcherInterface {
    return EventDispatcher(eventBus)
  }
}
