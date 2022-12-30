package com.vudang.kotlin.hexagon.adapter.config

import com.vudang.kotlin.hexagon.domain.context.HexagonContext
import org.axonframework.commandhandling.GenericCommandMessage
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.messaging.MetaData
import org.springframework.stereotype.Component

@Component
class HexagonCommandGateway(private val commandGateway: CommandGateway) {
  fun <R> sendAndWait(context: HexagonContext?, command: Any?): R {
    return commandGateway.sendAndWait(
      GenericCommandMessage.asCommandMessage<Any>(command!!)
        .withMetaData(MetaData.with(AdapterConst.CONTEXT_KEY, context))
    )
  }
}
