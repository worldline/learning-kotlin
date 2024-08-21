package example.com

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.title

val replies = mutableListOf<String>()

fun Application.configureCollector() {
    routing {
        post("/collect") {

        }

        get("/ui") {
            call.respondHtml {
                head {
                    title = "Quiz Collector"
                }
                body {
                    h1 { +"Quiz Collector" }

                }
            }
        }
    }
}