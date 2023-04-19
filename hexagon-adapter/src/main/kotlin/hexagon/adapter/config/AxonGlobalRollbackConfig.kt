package hexagon.adapter.config

import kotlin.Exception
import org.axonframework.messaging.unitofwork.RollbackConfiguration

class AxonGlobalRollbackConfig() : RollbackConfiguration {
  override fun rollBackOn(throwable: Throwable?): Boolean {
    return throwable is Exception
  }
}
