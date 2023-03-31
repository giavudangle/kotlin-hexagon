package com.vudang.kotlin.hexagon.domain.repository

import com.vudang.kotlin.hexagon.domain.entity.Account
import org.springframework.stereotype.Repository

interface AccountRepository : BaseRepository<Account> {
  fun findByEmail(email: String): Account?
}
