package com.vudang.kotlin.hexagon.api.service

import com.vudang.kotlin.hexagon.api.dto.AccountDTO

interface AccountService {
  fun findById(id: Long): AccountDTO
  fun seeding() : String
}
