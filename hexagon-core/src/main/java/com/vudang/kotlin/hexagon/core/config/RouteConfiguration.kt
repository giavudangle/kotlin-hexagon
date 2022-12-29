package com.vudang.kotlin.hexagon.core.config

class RouteConfiguration {
    companion object AccountConfiguration {
        object AccountRoute {
            private const val ROOT = "/account"
            const val FIND = "$ROOT/{id}"
            const val SEEDING = "$ROOT/seeding"

        }
    }
}


