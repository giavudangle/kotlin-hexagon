package com.vudang.kotlin.hexagon.core.port.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController class MainController() {
    @GetMapping("/")
    @ResponseBody
    fun health(): Map<String, String> {
        return mapOf(
            "Application: " to "Kotlin Hexagon",
            "Version: " to "1.0.0-SNAPSHOT",
            "Status: " to "Available"
        )
    }
}
