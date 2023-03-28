package com.vudang.kotlin.hexagon.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication open class Application {}

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
