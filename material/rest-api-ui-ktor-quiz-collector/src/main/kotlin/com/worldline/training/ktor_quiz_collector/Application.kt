package com.worldline.training.ktor_quiz_collector

import com.worldline.training.ktor_quiz_collector.plugins.configureHTTP
import com.worldline.training.ktor_quiz_collector.plugins.configureRouting
import com.worldline.training.ktor_quiz_collector.plugins.configureSerialization
import com.worldline.training.ktor_quiz_collector.plugins.configureTemplating
import com.worldline.training.ktor_quiz_collector.routes.configureMiscRoutes
import com.worldline.training.ktor_quiz_collector.routes.configureQuizCollector
import com.worldline.training.ktor_quiz_collector.utils.addSampleValues
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.cio.EngineMain.main(args)
}

fun Application.module() {
//    (1..10).forEach { _ ->
//        addSampleValues()
//    }
    configureHTTP()
    configureTemplating()
    configureSerialization()
    configureRouting()
    configureMiscRoutes()
    configureQuizCollector()
}
