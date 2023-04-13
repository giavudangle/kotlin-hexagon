package com.vudang.kotlin.hexagon.adapter.commandhandler

import com.vudang.kotlin.hexagon.adapter.command.CreateAccountCommand
import com.vudang.kotlin.hexagon.domain.event.AccountCreatedEvent
import com.vudang.kotlin.hexagon.domain.EventDispatcherInterface
import com.vudang.kotlin.hexagon.domain.entity.Account
import com.vudang.kotlin.hexagon.domain.exception.EntityAlreadyExistException
import com.vudang.kotlin.hexagon.domain.repository.AccountRepository
import org.axonframework.commandhandling.CommandHandler
import org.springframework.stereotype.Component

@Component
class CreateAccountHandler(
  private val accountRepository: AccountRepository,
  private val eventDispatcher: EventDispatcherInterface
) {
  @CommandHandler
  fun handle(command: CreateAccountCommand) {
    val existedAccount = this.accountRepository.findByEmail(command.email)
    if (existedAccount != null) {
      throw EntityAlreadyExistException()
    }

    val account = Account(name = command.name, email = command.email, password = command.password)
    this.accountRepository.persist(account)

    account.buildCreatedEvent()
    eventDispatcher.dispatch(account.flushEvents())
  }
}
