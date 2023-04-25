package tech.worldline.demo

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class QuizAPI(private val httpClient: HttpClient = HttpClient()) {

    init {
        httpClient.config {
            install(ContentNegotiation) {
//                json()
                // uncomment if you call https://awl.li/devoxxkmm2023
                json(
                    contentType = ContentType.Text.Plain, // because Github is not returning an 'application/json' header
                    json = Json {
                        ignoreUnknownKeys = true
                        useAlternativeNames = false
                    }
                )
            }
        }
    }

    suspend fun getAllQuestions(): Quiz {
        // uncomment for non desktop platforms
        val url = "https://awl.li/devoxxkmm2023"
//        val url = "http://127.0.0.1:8081/quiz"
        val result: Quiz = httpClient.get(url).body()
        return result
    }
}