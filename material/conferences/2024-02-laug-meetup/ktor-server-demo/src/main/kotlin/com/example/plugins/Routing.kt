package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class StreetFighter(val name: String, val superMove: String)

val streetFighters = listOf(
    StreetFighter("Ryu", "Shinku Hadoken"),
    StreetFighter("Ken", "Shoryuken"),
    StreetFighter("Chun-Li", "Kikosho"),
    StreetFighter("Guile", "Sonic Hurricane"),
    StreetFighter("Zangief", "Final Atomic Buster"),
    StreetFighter("Dhalsim", "Yoga Catastrophe"),
    StreetFighter("Blanka", "Ground Shave Roll"),
    StreetFighter("E. Honda", "Sumo Headbutt"),
    StreetFighter("Balrog", "Gigaton Blow"),
    StreetFighter("Vega", "Bloody High Claw"),
    StreetFighter("Sagat", "Tiger Gen")
)

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hellooo World!")
        }

        get("/fighters") {
            call.respond(streetFighters)
        }
    }
}
