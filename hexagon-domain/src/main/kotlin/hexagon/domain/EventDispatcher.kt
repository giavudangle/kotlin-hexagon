package hexagon.domain

import hexagon.domain.event.BaseEvent

interface EventDispatcherInterface {
  fun dispatch(events: List<BaseEvent?>)
  fun <T : BaseEvent?> dispatch(event: T)
}
