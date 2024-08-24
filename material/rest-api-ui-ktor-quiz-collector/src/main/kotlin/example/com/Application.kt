package example.com

import example.com.plugins.configureHTTP
import example.com.plugins.configureRouting
import example.com.plugins.configureSerialization
import example.com.plugins.configureTemplating
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    quizResponses.addAll(sampleResponses)
    configureHTTP()
    configureTemplating()
    configureSerialization()
    configureRouting()
    configureQuizCollector()
}
