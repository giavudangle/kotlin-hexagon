package com.vudang.kotlin.hexagon.domain.exception

class EntityNotFoundException(message: String?, code: String) : BaseDomainException(message, CODE) {
  constructor() : this(MESSAGE, CODE) {}

  companion object {
    private const val CODE = "EX.002.ENTITY_NOT_FOUND_EXCEPTION"
    private const val MESSAGE = "Exception occurs: Entity not found"
  }
}
