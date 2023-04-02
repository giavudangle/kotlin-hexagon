package com.vudang.kotlin.hexagon.infrastructure

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication(
  scanBasePackages = ["com.vudang.kotlin.hexagon"]
)
open class Application {
}

fun main(args : Array<String>){
  runApplication<Application>(*args)
}