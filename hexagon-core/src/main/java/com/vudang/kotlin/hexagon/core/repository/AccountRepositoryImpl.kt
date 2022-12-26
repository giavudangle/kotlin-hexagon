package com.vudang.kotlin.hexagon.core.repository

import com.vudang.kotlin.hexagon.core.persistence.mapper.AccountMapper
import com.vudang.kotlin.hexagon.domain.entity.Account
import com.vudang.kotlin.hexagon.domain.repository.AccountRepository
import lombok.Getter
import org.springframework.stereotype.Component

@Component
@Getter
class AccountRepositoryImpl(override val mapper: AccountMapper) :
  BaseRepositoryImpl<Account, AccountMapper>(mapper), AccountRepository {}
