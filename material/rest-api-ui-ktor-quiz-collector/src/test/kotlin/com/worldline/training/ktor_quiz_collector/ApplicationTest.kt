package com.worldline.training.ktor_quiz_collector

import com.worldline.training.ktor_quiz_collector.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/webjars").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }
}
