package hexagon.adapter.commandhandler

import hexagon.adapter.command.CreateAccountCommand
import hexagon.domain.EventDispatcherInterface
import hexagon.domain.entity.Account
import hexagon.domain.exception.EntityAlreadyExistException
import hexagon.domain.repository.AccountRepository
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
