package com.vudang.kotlin.hexagon.api.dto

data class AccountDTOResponse(
  val id: Long,
  val name: String,
  val email: String,
  val password: String?
)
