package com.vudang.kotlin.hexagon

import kotlin.reflect.KClass
import org.springframework.boot.SpringApplication
import org.springframework.context.ApplicationContextInitializer

open class CustomApplication : SpringApplication() {
  override fun setInitializers(
    initializers: MutableCollection<out ApplicationContextInitializer<*>>?
  ) {
    super.setInitializers(initializers)
  }

  companion object {
    fun run(primaryResource: KClass<Any>, args: Array<String>) {
      run(primaryResource, args)
    }
  }
}
