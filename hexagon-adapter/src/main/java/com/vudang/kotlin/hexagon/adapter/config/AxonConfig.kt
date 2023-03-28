package com.vudang.kotlin.hexagon.adapter.config

import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.commandhandling.gateway.DefaultCommandGateway
import org.axonframework.messaging.interceptors.BeanValidationInterceptor
import org.axonframework.queryhandling.DefaultQueryGateway
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.SimpleQueryBus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AxonConfig {

  // TODO: Find root cause why don't have bean when using custom bus

  @Bean
  fun commandBusGateway(simpleCommandBus: SimpleCommandBus): AxonCommandBusGateway {
    simpleCommandBus.setRollbackConfiguration(AxonGlobalRollbackConfig())
    simpleCommandBus.registerDispatchInterceptor(BeanValidationInterceptor())
    return AxonCommandBusGateway(simpleCommandBus)
  }

  @Bean
  fun queryBusGateway(simpleQueryBus: SimpleQueryBus): AxonQueryBusGateway {
    return AxonQueryBusGateway(simpleQueryBus)
  }
}
