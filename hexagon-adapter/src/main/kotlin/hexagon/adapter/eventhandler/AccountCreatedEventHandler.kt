package hexagon.adapter.eventhandler

import hexagon.domain.event.AccountCreatedEvent
import lombok.RequiredArgsConstructor
import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Component

@Component
@RequiredArgsConstructor
class AccountCreatedEventHandler {

  @EventHandler
  fun on(event: AccountCreatedEvent) {
    // TODO: Handle when account created event
    println(event.account.email)
    println(event.account.password)
    println(event.account.name)
  }
}
