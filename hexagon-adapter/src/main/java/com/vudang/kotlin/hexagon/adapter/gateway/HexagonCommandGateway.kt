package com.vudang.kotlin.hexagon.adapter.gateway

import com.vudang.kotlin.hexagon.adapter.const.AdapterConst
import com.vudang.kotlin.hexagon.domain.context.HexagonContext
import org.axonframework.commandhandling.GenericCommandMessage
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.messaging.MetaData
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class HexagonCommandGateway(private val commandGateway: CommandGateway) {

  @Bean
  fun <R> sendAndWait(context: HexagonContext?, command: Any?): R {
    return commandGateway.sendAndWait(
      GenericCommandMessage.asCommandMessage<Any>(command!!)
        .withMetaData(MetaData.with(AdapterConst.CONTEXT_KEY, context))
    )
  }
}
