package com.vudang.kotlin.hexagon.core.service

import com.vudang.kotlin.hexagon.adapter.config.HexagonCommandGateway
import com.vudang.kotlin.hexagon.adapter.config.HexagonQueryGateway
import com.vudang.kotlin.hexagon.adapter.dto.AccountDTO
import com.vudang.kotlin.hexagon.adapter.query.AccountInformationQuery
import com.vudang.kotlin.hexagon.api.dto.AccountDTOResponse
import com.vudang.kotlin.hexagon.api.service.AccountService
import com.vudang.kotlin.hexagon.core.context.getContext
import org.springframework.stereotype.Component

@Component
class AccountServiceImpl(
  private val commandGateway: HexagonCommandGateway,
  private val queryGateway: HexagonQueryGateway
) : AccountService {
  override fun findById(id: Long): AccountDTOResponse {
    val accountDTO =
      queryGateway.query(getContext(), AccountInformationQuery(id), AccountDTO::class.java).get()
    return AccountDTOResponse(
      id = accountDTO.account.id,
      name = accountDTO.account.name,
      email = accountDTO.account.email,
      password = null
    )
  }

  override fun seeding(): String {
    return "OK"
  }
}
