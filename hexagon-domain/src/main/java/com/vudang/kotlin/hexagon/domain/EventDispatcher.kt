package com.vudang.kotlin.hexagon.domain

import com.vudang.kotlin.hexagon.domain.event.BaseEvent

interface EventDispatcherInterface {
  fun dispatch(events: List<BaseEvent?>)
  fun <T : BaseEvent?> dispatch(event: T)
}
