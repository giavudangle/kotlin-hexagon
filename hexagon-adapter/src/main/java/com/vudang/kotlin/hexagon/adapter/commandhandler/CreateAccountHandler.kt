package com.vudang.kotlin.hexagon.adapter.commandhandler

import com.vudang.kotlin.hexagon.adapter.command.CreateAccountCommand
import com.vudang.kotlin.hexagon.adapter.dto.AccountDTO
import com.vudang.kotlin.hexagon.domain.entity.Account
import com.vudang.kotlin.hexagon.domain.exception.EntityAlreadyExistException
import com.vudang.kotlin.hexagon.domain.repository.AccountRepository
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.modelling.command.AggregateRoot
import org.springframework.stereotype.Component

@Component
class CreateAccountHandler(private val accountRepository: AccountRepository) {

  @CommandHandler
  fun handle(command: CreateAccountCommand): AccountDTO {
    val existingAccount: Account = accountRepository.findByEmail(command.email)
    if (existingAccount != null) {
      throw EntityAlreadyExistException()
    }

    val account = Account(command.name, command.email, command.password)
    accountRepository.persist(account)

    return AccountDTO.fromAccount(account)
  }
}
