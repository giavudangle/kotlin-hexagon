package com.vudang.kotlin.hexagon.domain.context

class HexagonContext {
  companion object {
    fun getHexagonContext(): HexagonContext {
      return HexagonContext()
    }
  }
}
