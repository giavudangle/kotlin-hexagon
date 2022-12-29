package com.vudang.kotlin.hexagon.domain.exception

open class BaseDomainException(message: String?, val code: String) : Exception(message) {
  val exceptionContextVariables: ArrayList<String> = ArrayList()

  open fun rollbackTransactionOnThrow(): Boolean {
    return true
  }
}
