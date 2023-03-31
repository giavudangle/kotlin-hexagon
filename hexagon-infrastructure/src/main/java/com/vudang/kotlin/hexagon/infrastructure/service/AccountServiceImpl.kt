package com.vudang.kotlin.hexagon.infrastructure.service

import com.vudang.kotlin.hexagon.adapter.dto.AccountDTO
import com.vudang.kotlin.hexagon.adapter.query.AccountInformationQuery
import com.vudang.kotlin.hexagon.api.request.CreateAccountRequest
import com.vudang.kotlin.hexagon.api.response.AccountResponse
import com.vudang.kotlin.hexagon.api.response.BaseResponse
import com.vudang.kotlin.hexagon.api.service.AccountService
import com.vudang.kotlin.hexagon.domain.context.HexagonContext
import lombok.RequiredArgsConstructor
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.queryhandling.QueryGateway
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class AccountServiceImpl(
  private val queryGateway: QueryGateway,
  private val commandGateway: CommandGateway,
  private val eventStore: EventStore
) : AccountService {
  private val context: HexagonContext = HexagonContext.getHexagonContext()

  override fun findById(id: Long): BaseResponse<AccountResponse> {
    val account = queryGateway.query(AccountInformationQuery(id), AccountDTO::class.java).get()

    return BaseResponse.success(
      AccountResponse(id = account.id, name = account.name, email = account.email)
    )
  }

  override fun create(request: CreateAccountRequest): BaseResponse<AccountResponse> {

    //    val account: AccountDTO =
    //      commandGateway.sendAndWait(
    //        CreateAccountCommand(
    //          email = request.email,
    //          password = request.password,
    //          name = request.name
    //        )
    //      )
    //
    //    return BaseResponse.success(
    //      AccountResponse(id = account.id, name = account.name, email = account.email)
    //    )
    return BaseResponse.success(AccountResponse(0L, "", ""))
  }

  override fun getEventsByAccountId(accountId: Long): List<Any?> {
    return this.eventStore.readEvents(accountId.toString()).asStream().map { it.payload }.toList()
  }
}
