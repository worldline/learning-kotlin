package com.worldline.training

import com.worldline.training.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8082, host = "localhost") {
                configureSerialization()
                configureRouting()
            }
            .start(wait = true)
}
