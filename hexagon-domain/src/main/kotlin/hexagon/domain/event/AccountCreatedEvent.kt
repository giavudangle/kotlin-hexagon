package hexagon.domain.event

import hexagon.domain.entity.Account
import java.util.*

class AccountCreatedEvent(val account: Account) : BaseDomainEvent() {}
