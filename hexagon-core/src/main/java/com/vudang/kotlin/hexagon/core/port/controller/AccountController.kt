package com.vudang.kotlin.hexagon.core.port.controller

import com.vudang.kotlin.hexagon.api.dto.AccountDTOResponse
import com.vudang.kotlin.hexagon.api.service.AccountService
import com.vudang.kotlin.hexagon.core.port.config.RouteConfiguration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController(private val accountService: AccountService) {
  private val route by lazy { RouteConfiguration.AccountConfiguration.AccountRoute }

  @GetMapping("/")
  @ResponseBody
  fun root(): Map<String, String> {
    return mapOf(
      "Application: " to "Kotlin Hexagon",
      "Version: " to "1.0.0-SNAPSHOT",
      "Status: " to "Available"
    )
  }

  @GetMapping(route.SEEDING)
  @ResponseBody
  fun seeding(): String {
    return accountService.seeding()
  }

  @GetMapping(route.FIND)
  @ResponseBody
  fun find(@PathVariable id: Long): AccountDTOResponse {
    return accountService.findById(id)
  }
}
