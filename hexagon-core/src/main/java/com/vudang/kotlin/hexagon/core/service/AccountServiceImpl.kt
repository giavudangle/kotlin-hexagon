package com.vudang.kotlin.hexagon.core.service

import com.vudang.kotlin.hexagon.api.dto.AccountDTO
import com.vudang.kotlin.hexagon.api.service.AccountService
import com.vudang.kotlin.hexagon.domain.entity.Account
import com.vudang.kotlin.hexagon.domain.repository.AccountRepository
import org.springframework.stereotype.Component

@Component
class AccountServiceImpl(private val accountRepository: AccountRepository) : AccountService {
  override fun findById(id: Long): AccountDTO {
    val account : Account =  accountRepository.find(id)
    return AccountDTO(id = account.id, name = account.name, email = account.email, password = null)
  }

  override fun seeding(): String {
    accountRepository.persist(Account(name = "Vu Dang", email = "legiavu.dang@lazada.com", password = "password"))
    return "Create seeding data for account successfully"
  }
}
