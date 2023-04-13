package com.vudang.kotlin.hexagon.adapter.eventbus

import org.axonframework.eventhandling.GenericEventMessage

open class IntegrationEventMessage<T>(payload: T) : GenericEventMessage<T>(payload)
