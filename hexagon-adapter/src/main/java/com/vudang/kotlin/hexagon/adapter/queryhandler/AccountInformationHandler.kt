package com.vudang.kotlin.hexagon.adapter.queryhandler

import com.vudang.kotlin.hexagon.adapter.dto.AccountDTO
import com.vudang.kotlin.hexagon.adapter.query.AccountInformationQuery
import com.vudang.kotlin.hexagon.domain.exception.EntityNotFoundException
import com.vudang.kotlin.hexagon.domain.repository.AccountRepository
import org.axonframework.queryhandling.QueryHandler
import org.springframework.stereotype.Component

@Component
class AccountInformationHandler(private val accountRepository: AccountRepository) {

  @QueryHandler
  fun handle(query: AccountInformationQuery): AccountDTO {
    val account = accountRepository.find(query.id) ?: throw EntityNotFoundException()
    return AccountDTO(account)
  }
}
