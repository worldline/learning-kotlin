package example.com

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*

val quizResponses = mutableListOf<QuizResponse>()

data class CollectResponse(val score: Int)

fun Application.configureQuizCollector() {
    routing {
        post("/collect") {
            val quizResponse = call.receive<QuizResponse>()
            quizResponses.add(quizResponse)
            call.respond(CollectResponse(quizResponse.score))
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
                                    +"Score: ${quizResponse.score}"
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}