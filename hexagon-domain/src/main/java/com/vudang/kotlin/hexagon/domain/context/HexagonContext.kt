package com.vudang.kotlin.hexagon.domain.context

import org.springframework.stereotype.Component

@Component
class HexagonContext {
  companion object {
    fun getHexagonContext(): HexagonContext {
      return HexagonContext()
    }
  }
}
