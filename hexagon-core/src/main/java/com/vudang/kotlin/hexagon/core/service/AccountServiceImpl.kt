package com.vudang.kotlin.hexagon.core.service

import com.vudang.kotlin.hexagon.adapter.dto.AccountDTO
import com.vudang.kotlin.hexagon.adapter.query.AccountInformationQuery
import com.vudang.kotlin.hexagon.api.dto.AccountDTOResponse
import com.vudang.kotlin.hexagon.api.service.AccountService
import lombok.RequiredArgsConstructor
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.queryhandling.QueryGateway
import org.springframework.stereotype.Component

@Component
@RequiredArgsConstructor
class AccountServiceImpl(
  private val queryGateway: QueryGateway,
  private val commandGateway: CommandGateway
) : AccountService {
  override fun findById(id: Long): AccountDTOResponse {
//    val accountDTO = queryGateway.query(AccountInformationQuery(id), AccountDTO::class.java).get()
//    return AccountDTOResponse(
//      id = accountDTO.account.id,
//      name = accountDTO.account.name,
//      email = accountDTO.account.email,
//      password = null
//    )
    return AccountDTOResponse(
      1L,
      "Test",
      "test@test.com",
      "test"
    )
  }

  override fun seeding(): String {
    return commandGateway.send<>()
  }
}
