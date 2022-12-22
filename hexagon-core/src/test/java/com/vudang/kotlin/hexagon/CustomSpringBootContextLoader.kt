package com.vudang.kotlin.hexagon

import org.springframework.boot.SpringApplication
import org.springframework.boot.test.context.SpringBootContextLoader

open class CustomSpringBootContextLoader : SpringBootContextLoader() {

  override fun getSpringApplication(): SpringApplication {
    return CustomApplication()
  }
}
