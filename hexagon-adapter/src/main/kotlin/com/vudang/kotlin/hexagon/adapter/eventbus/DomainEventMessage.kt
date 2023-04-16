package com.vudang.kotlin.hexagon.adapter.eventbus

import org.axonframework.eventhandling.GenericEventMessage

class DomainEventMessage<T>(payload: T) : GenericEventMessage<T>(payload)
