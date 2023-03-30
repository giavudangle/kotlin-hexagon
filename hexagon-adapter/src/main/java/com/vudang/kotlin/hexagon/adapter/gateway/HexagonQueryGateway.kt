package com.vudang.kotlin.hexagon.adapter.gateway

import com.vudang.kotlin.hexagon.adapter.config.AxonQueryBusGateway
import com.vudang.kotlin.hexagon.adapter.const.AdapterConst
import com.vudang.kotlin.hexagon.domain.context.HexagonContext
import java.util.concurrent.CompletableFuture
import org.axonframework.messaging.GenericMessage
import org.axonframework.messaging.MetaData
import org.axonframework.messaging.responsetypes.ResponseType
import org.axonframework.queryhandling.QueryMessage
import org.springframework.stereotype.Component

@Component
class HexagonQueryGateway(private val queryBusGateway: AxonQueryBusGateway) {
  fun <R, Q> query(
    context: HexagonContext,
    query: Q,
    responseType: ResponseType<R>
  ): CompletableFuture<R> {
    return queryBusGateway.query(
      GenericMessage.asMessage(query)
        .withMetaData(MetaData.with(AdapterConst.CONTEXT_KEY, context)),
      responseType
    )
  }

  fun <R, Q> query(query: Q, responseType: ResponseType<R>): CompletableFuture<R> {
    return queryBusGateway.query(QueryMessage.queryName(query as Any), query, responseType)
  }

  fun <R, Q> query(context: HexagonContext, query: Q, classType: Class<R>): CompletableFuture<R> {
    return this.query(context, query, classType)
  }
}
