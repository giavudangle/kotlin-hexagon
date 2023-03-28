package com.vudang.kotlin.hexagon.core.port.controller

import com.vudang.kotlin.hexagon.api.request.CreateAccountRequest
import com.vudang.kotlin.hexagon.api.response.AccountResponse
import com.vudang.kotlin.hexagon.api.response.BaseResponse
import com.vudang.kotlin.hexagon.api.service.AccountService
import org.springframework.web.bind.annotation.*

@RestController
class AccountController(private val accountService: AccountService) {
  private object Constants {
    const val ROOT = "/account"
    const val FIND = "$ROOT/{id}"
  }

  @GetMapping(Constants.FIND)
  @ResponseBody
  fun find(@PathVariable id: Long): BaseResponse<AccountResponse> {
    return accountService.findById(id)
  }

  @PostMapping(Constants.ROOT)
  @ResponseBody
  fun createAccount(@RequestBody request: CreateAccountRequest): BaseResponse<AccountResponse> {
    return accountService.create(request)
  }
}
