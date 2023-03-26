package com.vudang.kotlin.hexagon.adapter.gateway

import com.vudang.kotlin.hexagon.adapter.const.AdapterConst
import com.vudang.kotlin.hexagon.domain.context.HexagonContext
import lombok.RequiredArgsConstructor
import java.util.concurrent.CompletableFuture
import kotlin.reflect.KClass
import org.axonframework.messaging.GenericMessage
import org.axonframework.messaging.MetaData
import org.axonframework.messaging.responsetypes.ResponseType
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.SimpleQueryBus
import org.springframework.stereotype.Component

@Component
class HexagonQueryGateway(private val queryGateway: QueryGateway) {
  fun <R, Q> query(
    context: HexagonContext,
    query: Q,
    responseType: ResponseType<R>
  ): CompletableFuture<R> {
    return queryGateway.query(
      GenericMessage.asMessage(query)
        .withMetaData(MetaData.with(AdapterConst.CONTEXT_KEY, context)),
      responseType
    )
  }

  fun <R, Q> query(context: HexagonContext, query: Q, classType: Class<R>): CompletableFuture<R> {
    return this.query(context, query, classType)
  }

}
