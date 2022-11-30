package com.vudang.kotlin.hexagon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class Application

fun main(args : Array<String>){
    runApplication<Application>(*args)
}