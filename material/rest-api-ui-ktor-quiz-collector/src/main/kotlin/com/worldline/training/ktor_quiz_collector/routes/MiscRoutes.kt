package com.worldline.training.ktor_quiz_collector.routes

import com.worldline.training.ktor_quiz_collector.plugins.respondCss
import com.worldline.training.ktor_quiz_collector.utils.getCorrectStats
import com.worldline.training.ktor_quiz_collector.utils.quizResponses
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.css.Color
import kotlinx.css.Display
import kotlinx.css.FlexWrap
import kotlinx.css.Gap
import kotlinx.css.JustifyContent
import kotlinx.css.TextAlign
import kotlinx.css.backgroundColor
import kotlinx.css.body
import kotlinx.css.border
import kotlinx.css.display
import kotlinx.css.flexWrap
import kotlinx.css.gap
import kotlinx.css.h1
import kotlinx.css.justifyContent
import kotlinx.css.margin
import kotlinx.css.marginTop
import kotlinx.css.p
import kotlinx.css.padding
import kotlinx.css.properties.boxShadow
import kotlinx.css.px
import kotlinx.css.rem
import kotlinx.css.svg
import kotlinx.css.textAlign
import kotlinx.html.body
import kotlinx.html.h1

fun Application.configureHelloRoutes() {
    routing {
        get("/hello") {
            call.respondHtml {
                body {
                    h1 { +"Hello Ktor" }
                }
            }
        }

        get("/data") {
            call.respond(quizResponses)
        }
    }
}

fun Application.configureMiscRoutes() {
    routing {
        get("/responses") {
            call.respond(quizResponses.map { quizResponse ->
                quizResponse.responses.fold(mutableMapOf<String, String>()) { acc, element ->
                    acc[element.question] = element.answer
                    acc
                }
            })
        }

        staticResources("/static", "static")

        get("/styles-graph.css") {
            call.respondCss {
                body {
                    backgroundColor = Color.lightCyan
                    margin(0.px)
                    padding(0.px)
                }
                h1 {
                    textAlign = TextAlign.center
                    backgroundColor = Color.lightGreen
                    marginTop = 0.px
                    padding(1.5.rem)
                }
                p {
                    textAlign = TextAlign.center
                }
                rule("div") {
                    display = Display.flex
                    flexWrap = FlexWrap.wrap
                    justifyContent = JustifyContent.center
                    gap = Gap("1rem")
                }
                svg {
                    border = "1px solid black"
                    boxShadow(Color.black, 2.px, 2.px, 2.px)
                }
            }
        }

        get("/favicon.ico") {
            val image = call.resolveResource("static/favicon.ico")
            if (image != null) {
                call.respond(image)
            } else {
                call.respond(HttpStatusCode.NotFound)
            }
        }

        get("/responses") {
            call.respond(quizResponses.map { quizResponse ->
                quizResponse.responses.fold(mutableMapOf<String, String>()) { acc, element ->
                    acc[element.question] = element.answer
                    acc
                }
            })
        }

        get("/correct-stats") {
            call.respond(getCorrectStats())
        }

        get("/table2") {
            call.respond(quizResponses)
        }

        get("/table") {
            val result = quizResponses.flatMap { it.responses }.groupBy { it.question }
                .mapValues { it.value.map { value -> value.answer } }
            call.respond(result)
        }

        get("/table2") {
            call.respond(quizResponses)
        }
    }
}