package com.vudang.kotlin.hexagon.adapter.event

import java.util.*

class AccountCreatedEvent(val accountId : UUID,val email: String, val name: String, val password: String) {}
