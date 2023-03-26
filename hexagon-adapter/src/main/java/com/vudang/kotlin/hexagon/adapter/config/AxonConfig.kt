package com.vudang.kotlin.hexagon.adapter.config

import org.axonframework.commandhandling.CommandBus
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.commandhandling.gateway.DefaultCommandGateway
import org.axonframework.messaging.interceptors.BeanValidationInterceptor
import org.axonframework.queryhandling.DefaultQueryGateway
import org.axonframework.queryhandling.QueryBus
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.SimpleQueryBus
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AxonConfig {
    @Bean
    fun commandGateway(simpleCommandBus: SimpleCommandBus) : CommandGateway {
        simpleCommandBus.setRollbackConfiguration(AxonGlobalRollbackConfig())
        simpleCommandBus.registerDispatchInterceptor(BeanValidationInterceptor())
        return DefaultCommandGateway.builder().commandBus(simpleCommandBus).build()
    }

    @Bean
    fun queryGateway(simpleQueryBus: SimpleQueryBus) : QueryGateway {
        return DefaultQueryGateway.builder().queryBus(simpleQueryBus).build();
    }

}