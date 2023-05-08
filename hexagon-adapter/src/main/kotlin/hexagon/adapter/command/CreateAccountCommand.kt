package hexagon.adapter.command

import java.util.*

class CreateAccountCommand(
  val accountId: UUID,
  val email: String,
  val name: String,
  val password: String
) : BaseCommand() {}
