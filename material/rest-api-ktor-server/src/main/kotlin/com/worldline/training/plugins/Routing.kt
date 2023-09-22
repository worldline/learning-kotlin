package com.worldline.training.plugins

import com.worldline.training.routes.customerRouting
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    routing {
        customerRouting()
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
