package com.vudang.kotlin.hexagon.adapter.config

import org.axonframework.messaging.unitofwork.RollbackConfiguration
import kotlin.Exception

class AxonGlobalRollbackConfig() : RollbackConfiguration {
  override fun rollBackOn(throwable: Throwable?): Boolean {
    return throwable is Exception
  }
}
