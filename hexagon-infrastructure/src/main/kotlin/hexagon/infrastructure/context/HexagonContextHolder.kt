package hexagon.infrastructure.context

import hexagon.api.service.BaseService
import hexagon.domain.context.HexagonContext

val THREAD_LOCAL_CONTEXT = ThreadLocal<HexagonContext>()

fun BaseService.getContext(): HexagonContext {
  return THREAD_LOCAL_CONTEXT.get()
}

internal fun getContext(): HexagonContext? {
  return THREAD_LOCAL_CONTEXT.get()
}
