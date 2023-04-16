package com.vudang.kotlin.hexagon.api.service

import com.vudang.kotlin.hexagon.api.request.CreateAccountRequest
import com.vudang.kotlin.hexagon.api.response.AccountResponse
import com.vudang.kotlin.hexagon.api.response.BaseResponse

interface AccountService : BaseService {
  fun findById(id: Long): BaseResponse<AccountResponse>
  fun create(request: CreateAccountRequest): BaseResponse<Boolean>
}
