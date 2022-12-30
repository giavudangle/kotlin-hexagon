package com.vudang.kotlin.hexagon.api.service

import com.vudang.kotlin.hexagon.api.dto.AccountDTOResponse

interface AccountService : BaseService {
  fun findById(id: Long): AccountDTOResponse
  fun seeding(): String
}
