package hexagon.adapter.dto

import hexagon.domain.entity.Account

data class AccountDTO(val id: Long, val name: String, val email: String) {
  companion object {
    fun fromAccount(account: Account): AccountDTO {
      return AccountDTO(id = account.id, name = account.name, email = account.email)
    }
  }
}
