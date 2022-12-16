package com.vudang.kotlin.hexagon.core.persistence.plugin

import com.vudang.kotlin.hexagon.domain.entity.BaseEntity
import java.time.Instant
import org.apache.ibatis.executor.Executor
import org.apache.ibatis.mapping.MappedStatement
import org.apache.ibatis.mapping.SqlCommandType
import org.apache.ibatis.plugin.Interceptor
import org.apache.ibatis.plugin.Intercepts
import org.apache.ibatis.plugin.Invocation
import org.apache.ibatis.plugin.Signature

@Intercepts(
  Signature(
    type = Executor::class,
    method = "update",
    args = arrayOf(MappedStatement::class, Object::class)
  )
)
class TimestampPlugin : Interceptor {
  override fun intercept(invocation: Invocation): Any {
    val statement = invocation.args[0] as MappedStatement
    val params = invocation.args[1] as Any

    when (statement.sqlCommandType) {
      SqlCommandType.INSERT -> {
        if (params is BaseEntity) {
          params.createdAt = Instant.now()
          params.updatedAt = Instant.now()
        }
      }
      SqlCommandType.UPDATE -> {
        if (params is BaseEntity) {
          params.updatedAt = Instant.now()
        }
      }
      else -> {}
    }
    return invocation.proceed()
  }
}
