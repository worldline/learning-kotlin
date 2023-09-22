package tech.worldline.demo

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

class QuizAPI {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                // uncomment if you call https://awl.li/devoxxkmm2023
//                contentType = ContentType.Text.Plain, // because Github is not returning an 'application/json' header
//                json = Json {
//                    ignoreUnknownKeys = true
//                    useAlternativeNames = false
//                }
            )
        }
    }

    suspend fun getAllQuestions(): Quiz {
        // uncomment for non desktop platforms
//        val url = "https://awl.li/devoxxkmm2023"
        val url = "http://localhost:8081/quiz"
        val result: Quiz = httpClient.get(url).body()
        return result
    }
}