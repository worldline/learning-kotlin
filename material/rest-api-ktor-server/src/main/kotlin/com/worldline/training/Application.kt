package com.worldline.training

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.worldline.training.plugins.*

fun main() {
    embeddedServer(Netty, port = 8082, host = "127.0.0.1") {
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
