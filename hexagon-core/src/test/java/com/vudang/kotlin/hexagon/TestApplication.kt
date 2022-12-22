package com.vudang.kotlin.hexagon

import jakarta.annotation.PostConstruct
import kotlin.reflect.KClass
import lombok.extern.slf4j.Slf4j
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@Slf4j
open class TestApplication {
  @PostConstruct fun initialize() {}

  fun main(args: Array<String>) {
    CustomApplication.run(TestApplication::class as KClass<Any>, args)
  }
}
