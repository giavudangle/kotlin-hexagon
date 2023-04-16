package com.vudang.kotlin.hexagon.adapter.event

import com.vudang.kotlin.hexagon.domain.event.BaseEvent
import java.util.*


abstract class BaseIntegrationEvent() : BaseEvent() {
    val uniqueKey = UUID.randomUUID().toString()
    val bornTime = System.currentTimeMillis()

    abstract fun getIdentifier() : String;
    abstract fun getEventGroup() : String;
}
