package com.vudang.kotlin.hexagon.domain.exception

import com.vudang.kotlin.hexagon.shared.exception.BaseDomainException

class OptimisticConcurrentException(reason: String?) : BaseDomainException(CODE, reason) {
  constructor() : this(REASON) {}

  companion object {
    private const val CODE = "EX.001.OPTIMISTIC_CONCURRENT_EXCEPTION"
    private const val REASON = "Optimistic concurrent exception occur, please retry later."
  }
}
