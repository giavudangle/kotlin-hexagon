package com.vudang.kotlin.hexagon.adapter.config

import org.axonframework.messaging.unitofwork.RollbackConfiguration

class AxonGlobalRollbackConfig() : RollbackConfiguration {
    override fun rollBackOn(throwable: Throwable?): Boolean {
        TODO("Not yet implemented")
    }
}