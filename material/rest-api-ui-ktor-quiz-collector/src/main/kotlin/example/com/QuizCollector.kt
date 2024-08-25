package example.com

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import kotlinx.serialization.Serializable
import org.jetbrains.kotlinx.dataframe.api.dataFrameOf
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.letsplot.export.toHTML
import org.jetbrains.kotlinx.kandy.letsplot.export.toSVG
import org.jetbrains.kotlinx.kandy.letsplot.layers.bars

@Serializable
data class QuestionStats(val question: String, val correct: Int)

fun Application.configureQuizCollector() {
    fun getCorrectStats() = quizResponses.flatMap { it.responses }.groupBy { it.question }
        .mapValues { it.value.count { qr -> qr.correctAnwserId == qr.anwserId } }
        .map { QuestionStats(it.key, it.value) }

    routing {
        post("/respond") {
            val quizResponse = call.receive<QuizResponse>()
            quizResponses.add(quizResponse)
            call.respond(CollectResponse(quizResponse.score))
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

        get("/reset") {
            quizResponses.clear()
            call.respond(HttpStatusCode.OK)
        }

        get("/ui") {
            call.respondHtml {
                head {
                    title = "Quiz Collector"
                }
                body {
                    h1 { +"Quiz Collector" }
                    div {
                        val correctStats = getCorrectStats()
                        val statsDataFrame = dataFrameOf("question" to correctStats.map { it.question },
                            "correct" to correctStats.map { it.correct })
                        val content = statsDataFrame.plot {
                            bars {
                                y("question")
                                x("correct")
                            }
                        }.toSVG()
                        unsafe { +content }
                    }
                }
            }
        }
        get("/ui/correct") {
            val correctStats = getCorrectStats()
            val statsDataFrame = dataFrameOf("question" to correctStats.map { it.question },
                "correct" to correctStats.map { it.correct })
            val html = statsDataFrame.plot {
                bars {
                    y("question")
                    x("correct")
                }
            }.toHTML(false)
            call.respondText(html, ContentType.Text.Html)
        }
    }
}