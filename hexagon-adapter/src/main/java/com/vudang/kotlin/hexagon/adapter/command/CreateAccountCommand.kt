package com.vudang.kotlin.hexagon.adapter.command

class CreateAccountCommand(val name: String, val email: String, val password: String) :
  BaseCommand() {}
