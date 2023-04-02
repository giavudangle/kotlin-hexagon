package com.vudang.kotlin.hexagon.adapter.command

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

class CreateAccountCommand(
  @TargetAggregateIdentifier val accountId : UUID,
  val email: String,
  val name: String,
  val password: String
) : BaseCommand() {}
