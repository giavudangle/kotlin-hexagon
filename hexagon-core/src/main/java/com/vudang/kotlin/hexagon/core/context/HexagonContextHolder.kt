package com.vudang.kotlin.hexagon.core.context

import com.vudang.kotlin.hexagon.api.service.BaseService
import com.vudang.kotlin.hexagon.domain.context.HexagonContext

val THREAD_LOCAL_CONTEXT = ThreadLocal<HexagonContext>()

fun BaseService.getContext(): HexagonContext {
  return THREAD_LOCAL_CONTEXT.get()
}

internal fun getContext(): HexagonContext? {
  return THREAD_LOCAL_CONTEXT.get()
}
