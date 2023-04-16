package com.vudang.kotlin.hexagon.infrastructure.service

import com.vudang.kotlin.hexagon.adapter.command.CreateAccountCommand
import com.vudang.kotlin.hexagon.adapter.dto.AccountDTO
import com.vudang.kotlin.hexagon.adapter.query.AccountInformationQuery
import com.vudang.kotlin.hexagon.api.request.CreateAccountRequest
import com.vudang.kotlin.hexagon.api.response.AccountResponse
import com.vudang.kotlin.hexagon.api.response.BaseResponse
import com.vudang.kotlin.hexagon.api.service.AccountService
import com.vudang.kotlin.hexagon.domain.context.HexagonContext
import java.util.*
import lombok.RequiredArgsConstructor
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.queryhandling.QueryGateway
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class AccountServiceImpl(
  private val queryGateway: QueryGateway,
  private val commandGateway: CommandGateway
) : AccountService {
  private val context: HexagonContext = HexagonContext.getHexagonContext()

  override fun findById(id: Long): BaseResponse<AccountResponse> {
    val account = queryGateway.query(AccountInformationQuery(id), AccountDTO::class.java).get()

    return BaseResponse.success(
      AccountResponse(id = account.id, name = account.name, email = account.email)
    )
  }

  override fun create(request: CreateAccountRequest): BaseResponse<Boolean> {
    commandGateway.sendAndWait<Any>(
      CreateAccountCommand(
        accountId = UUID.randomUUID(),
        email = request.email,
        password = request.password,
        name = request.name
      )
    )

    return BaseResponse.ok()
  }
}
