package tech.worldline.demo.server

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import kotlinx.serialization.json.Json
import tech.worldline.demo.generateQuiz

fun HTML.index() {
    head {
        title("Hello from Ktor!")
    }
    body {
        div {
            +"Hello from Ktor"
        }
        div {
            id = "root"
            +"Current quiz: "
            ul {
                for (question in generateQuiz().questions) {
                    li {
                        +question.toString()
                    }
                }
            }
        }

    }
}

fun main() {
    embeddedServer(Netty, port = 8081, host = "127.0.0.1") {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
            })
        }
        // Cors is required to be able to fetch the JS code
        install(CORS) {
            allowHeader(HttpHeaders.ContentType)
            allowMethod(HttpMethod.Get)
            allowMethod(HttpMethod.Post)
            allowMethod(HttpMethod.Delete)
            anyHost()
        }
        routing {
            get("/quiz.html") {
                call.respondHtml(HttpStatusCode.OK, HTML::index)
            }
            get("/quiz") {
                call.respond(generateQuiz())
            }
            get("/") {
                call.respondText(
                    this::class.java.classLoader.getResource("index.html")!!.readText(),
                    ContentType.Text.Html
                )
            }
            static("/") {
                resources()
            }
        }
    }.start(wait = true)
}