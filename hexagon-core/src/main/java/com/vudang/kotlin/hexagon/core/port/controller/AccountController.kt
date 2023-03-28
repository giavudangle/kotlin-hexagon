package com.vudang.kotlin.hexagon.core.port.controller

import com.vudang.kotlin.hexagon.api.dto.AccountDTOResponse
import com.vudang.kotlin.hexagon.api.service.AccountService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController(private val accountService: AccountService) {
  private object Constants {
    const val ROOT = "/account"
    const val FIND = "$ROOT/{id}"
  }

  @GetMapping(Constants.ROOT)
  @ResponseBody
  fun seeding(): String {
    return accountService.seeding()
  }

  @GetMapping(Constants.FIND)
  @ResponseBody
  fun find(@PathVariable id: Long): AccountDTOResponse {
    return accountService.findById(id)
  }
}
