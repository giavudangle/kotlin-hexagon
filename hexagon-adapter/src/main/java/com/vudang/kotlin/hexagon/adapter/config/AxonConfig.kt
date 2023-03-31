package com.vudang.kotlin.hexagon.adapter.config

import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.messaging.interceptors.BeanValidationInterceptor
import org.axonframework.queryhandling.SimpleQueryBus
import org.axonframework.serialization.Serializer
import org.axonframework.serialization.json.JacksonSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
open class AxonConfig {
  @Bean
  open fun commandBusGateway(simpleCommandBus: SimpleCommandBus): AxonCommandBusGateway {
    simpleCommandBus.setRollbackConfiguration(AxonGlobalRollbackConfig())
    simpleCommandBus.registerDispatchInterceptor(BeanValidationInterceptor())
    return AxonCommandBusGateway(simpleCommandBus)
  }

  @Bean
  open fun queryBusGateway(simpleQueryBus: SimpleQueryBus): AxonQueryBusGateway {
    return AxonQueryBusGateway(simpleQueryBus)
  }

  @Bean
  @Primary
  open fun jacksonSerializer(): Serializer {
    return JacksonSerializer.defaultSerializer()
  }
}
