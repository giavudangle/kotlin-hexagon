package com.vudang.kotlin.hexagon.domain.event

import com.vudang.kotlin.hexagon.domain.entity.Account
import java.util.*

class AccountCreatedEvent(val account: Account) :
  BaseDomainEvent() {
}
