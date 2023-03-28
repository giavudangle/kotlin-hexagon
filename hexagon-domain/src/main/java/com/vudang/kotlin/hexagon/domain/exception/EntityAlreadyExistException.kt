package com.vudang.kotlin.hexagon.domain.exception

class EntityAlreadyExistException(message: String?, code: String) :
  BaseDomainException(message, CODE) {
  constructor() : this(MESSAGE, CODE) {}

  companion object {
    private const val CODE = "EX.003.ENTITY_ALREADY_EXIST_EXCEPTION"
    private const val MESSAGE = "Exception occurs: Entity already exist"
  }
}
