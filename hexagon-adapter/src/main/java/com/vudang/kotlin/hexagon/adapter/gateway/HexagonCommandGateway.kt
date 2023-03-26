package com.vudang.kotlin.hexagon.adapter.gateway

import com.vudang.kotlin.hexagon.adapter.config.AxonCommandBusGateway
import com.vudang.kotlin.hexagon.adapter.const.AdapterConst
import com.vudang.kotlin.hexagon.domain.context.HexagonContext
import org.axonframework.commandhandling.GenericCommandMessage
import org.axonframework.messaging.MetaData
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class HexagonCommandGateway(private val commandBusGateway: AxonCommandBusGateway) {

  @Bean
  fun <R> sendAndWait(context: HexagonContext?, command: Any?): R {
    return commandBusGateway.sendAndWait(
      GenericCommandMessage.asCommandMessage<Any>(command!!)
        .withMetaData(MetaData.with(AdapterConst.CONTEXT_KEY, context))
    )
  }
}
