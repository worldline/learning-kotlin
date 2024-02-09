package com.example.plugins

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable data class StreetFighter(val name: String, val health: Int)

var streetFighters = listOf(StreetFighter("Ryu", 100), StreetFighter("Ken", 100))

fun Application.configureRouting() {
    routing {
        get("/") { call.respondText("Hello World!") }
        get("/fighters", { description = "Get all street fighters" }) {
            call.respond(streetFighters)
        }
        post("/fighters") {
            val streetFighter = call.receive<StreetFighter>()
            streetFighters += streetFighter
            call.response.status(HttpStatusCode.Created)
        }
    }
}
