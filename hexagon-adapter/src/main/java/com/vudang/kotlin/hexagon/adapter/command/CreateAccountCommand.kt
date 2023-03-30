package com.vudang.kotlin.hexagon.adapter.command

import org.axonframework.modelling.command.TargetAggregateIdentifier

class CreateAccountCommand(
  @TargetAggregateIdentifier val email: String,
  val name: String,
  val password: String
) : BaseCommand() {}
