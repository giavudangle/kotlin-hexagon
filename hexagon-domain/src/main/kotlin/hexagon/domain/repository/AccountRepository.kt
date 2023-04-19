package hexagon.domain.repository

import hexagon.domain.entity.Account

interface AccountRepository : BaseRepository<Account> {
  fun findByEmail(email: String): Account?
}
