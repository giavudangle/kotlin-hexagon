package com.vudang.kotlin.hexagon.adapter.aggregate

import com.vudang.kotlin.hexagon.adapter.command.CreateAccountCommand
import com.vudang.kotlin.hexagon.adapter.dto.AccountDTO
import com.vudang.kotlin.hexagon.adapter.event.AccountCreatedEvent
import com.vudang.kotlin.hexagon.domain.entity.Account
import com.vudang.kotlin.hexagon.domain.exception.EntityAlreadyExistException
import com.vudang.kotlin.hexagon.domain.repository.AccountRepository
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventhandling.EventHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate
import org.springframework.stereotype.Component
import java.util.*

@Component
@Aggregate
class AccountAggregate(private val accountRepository: AccountRepository) : BaseAggregate() {
  @AggregateIdentifier
  private var accountId : UUID =  UUID.randomUUID()
  private var email: String = ""
  private var name: String = ""
  private var password: String = ""

  @CommandHandler
  fun handle(command: CreateAccountCommand) {
    AggregateLifecycle.apply(
      AccountCreatedEvent(accountId = command.accountId,  email = command.email, name = command.name, password = command.password)
    )
  }

  @EventHandler
  fun on(event: AccountCreatedEvent){
    this.accountRepository.findByEmail(event.email) ?: throw EntityAlreadyExistException()
    this.accountRepository.persist(Account(name = event.name, email = event.email, password = event.password))
  }

  @EventSourcingHandler
  fun store(event: AccountCreatedEvent) {
    this.accountId = event.accountId
    this.email = event.email
    this.name = event.name
    this.password = event.password
  }
}
