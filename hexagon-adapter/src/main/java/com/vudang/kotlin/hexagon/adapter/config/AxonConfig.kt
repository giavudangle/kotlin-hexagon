package com.vudang.kotlin.hexagon.adapter.config

import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.messaging.interceptors.BeanValidationInterceptor
import org.axonframework.queryhandling.SimpleQueryBus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AxonConfig {
  @Bean
  fun commandBusGateway(simpleCommandBus: SimpleCommandBus): AxonCommandBusGateway {
    simpleCommandBus.setRollbackConfiguration(AxonGlobalRollbackConfig())
    simpleCommandBus.registerDispatchInterceptor(BeanValidationInterceptor())
    return AxonCommandBusGateway(simpleCommandBus)
  }

  @Bean
  fun queryGateway(simpleQueryBus: SimpleQueryBus): AxonQueryBusGateway {
    return AxonQueryBusGateway(simpleQueryBus)
  }
}
