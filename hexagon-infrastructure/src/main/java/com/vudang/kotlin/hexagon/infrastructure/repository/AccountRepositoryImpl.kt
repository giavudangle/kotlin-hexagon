package com.vudang.kotlin.hexagon.infrastructure.repository

import com.vudang.kotlin.hexagon.domain.entity.Account
import com.vudang.kotlin.hexagon.domain.repository.AccountRepository
import com.vudang.kotlin.hexagon.infrastructure.persistence.mapper.AccountMapper
import lombok.Getter
import org.springframework.stereotype.Component

@Component
@Getter
class AccountRepositoryImpl(override val mapper: AccountMapper) :
  BaseRepositoryImpl<Account, AccountMapper>(mapper), AccountRepository {
  override fun findByEmail(email: String): Account? {
    return mapper.findByEmail(email)
  }
}
