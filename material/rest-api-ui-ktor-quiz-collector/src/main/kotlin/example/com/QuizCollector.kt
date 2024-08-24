package example.com

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import kotlinx.serialization.Serializable

fun Application.configureQuizCollector() {
    routing {
        post("/respond") {
            val quizResponse = call.receive<QuizResponse>()
            quizResponses.add(quizResponse)
            call.respond(CollectResponse(quizResponse.getScore()))
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
            @Serializable
            data class QuestionStats(val question: String, val correct: Int)

            val result = quizResponses.flatMap { it.responses }.groupBy { it.question }
                .mapValues { it.value.count { qr -> correctResponses[qr.question] == qr.answer } }
                .map { QuestionStats(it.key, it.value) }
            call.respond(result)
        }

        get("/table2") {
            call.respond(quizResponses)
        }

        get("/table") {
            val result = quizResponses.flatMap { it.responses }.groupBy { it.question }
                .mapValues { it.value.map { value -> value.answer } }
            call.respond(result)
        }

        get("/ui") {
            call.respondHtml {
                head {
                    title = "Quiz Collector"
                }
                body {
                    h1 { +"Quiz Collector" }
                    if (quizResponses.isEmpty()) {
                        +"No responses yet."
                    } else {
                        +"Responses:"
                        ul {
                            quizResponses.forEach { quizResponse ->
                                li {
                                    +"Score: ${quizResponse.getScore()}"
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}