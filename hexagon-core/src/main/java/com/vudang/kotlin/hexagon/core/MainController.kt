package com.vudang.kotlin.hexagon.core

import com.vudang.kotlin.hexagon.domain.entity.Account
import com.vudang.kotlin.hexagon.domain.repository.AccountRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(private val accountRepository: AccountRepository) {

  @GetMapping("/")
  @ResponseBody
  fun root(): Map<String, String> {
    return mapOf(
      "Application: " to "Kotlin Hexagon",
      "Version: " to "1.0.0-SNAPSHOT",
      "Status: " to "Available"
    )
  }

  @GetMapping("/db")
  @ResponseBody
  fun db() : String {
    val account = Account("email@email.com","email")
    accountRepository.persist(account)
    return account.email
  }
}
