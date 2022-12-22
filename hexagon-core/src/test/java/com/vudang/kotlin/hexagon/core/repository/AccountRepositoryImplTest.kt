package com.vudang.kotlin.hexagon.core.repository

import com.vudang.kotlin.hexagon.BaseTest
import com.vudang.kotlin.hexagon.domain.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired

class AccountRepositoryImplTest : BaseTest() {
  @Autowired lateinit var repo: AccountRepository
}
