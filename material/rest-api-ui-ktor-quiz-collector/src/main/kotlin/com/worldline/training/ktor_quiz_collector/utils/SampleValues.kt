package com.worldline.training.ktor_quiz_collector.utils

import io.ktor.server.application.*
import kotlinx.serialization.json.Json

val json1 = """
    {
      "responses": [
        {
          "question": "What is the primary goal of Kotlin Multiplatform?",
          "answer": "To share code between multiple platforms",
          "answerId": 1,
          "id": 1,
          "correctAnswerId": 1
        },
        {
          "question": "How does Kotlin Multiplatform facilitate code sharing between platforms?",
          "answer": "By sharing business logic and adapting UI",
          "answerId": 1,
          "id": 2,
          "correctAnswerId": 1
        },
        {
          "question": "Which platforms does Kotlin Multiplatform support?",
          "answer": "Android, iOS, desktop and web",
          "answerId": 4,
          "id": 3,
          "correctAnswerId": 4
        },
        {
          "question": "What is a common use case for Kotlin Multiplatform?",
          "answer": "Developing a cross-platform app",
          "answerId": 4,
          "id": 4,
          "correctAnswerId": 4
        },
        {
          "question": "Which naming of KMP is deprecated?",
          "answer": "Kotlin Multiplatform Mobile (KMM)",
          "answerId": 4,
          "id": 5,
          "correctAnswerId": 4
        },
        {
          "question": "How does Kotlin Multiplatform handle platform-specific implementations?",
          "answer": "Through expect and actual declarations",
          "answerId": 3,
          "id": 6,
          "correctAnswerId": 3
        },
        {
          "question": "At which Google I/O, Google announced first-class support for Kotlin on Android?",
          "answer": "2017",
          "answerId": 3,
          "id": 7,
          "correctAnswerId": 3
        },
        {
          "question": "What is the name of the Kotlin mascot?",
          "answer": "Kodee",
          "answerId": 4,
          "id": 8,
          "correctAnswerId": 4
        },
        {
          "question": "The international yearly Kotlin conference is called...",
          "answer": "KotlinConf",
          "answerId": 4,
          "id": 9,
          "correctAnswerId": 4
        },
        {
          "question": "Where will be located the next international yearly Kotlin conference?",
          "answer": "Copenhagen, Denmark",
          "answerId": 4,
          "id": 10,
          "correctAnswerId": 4
        }
      ],
      "score": 10,
      "nickname": "user-650"
    }
""".trimIndent()

val json2 = """
    {
      "responses": [
        {
          "question": "What is the primary goal of Kotlin Multiplatform?",
          "answer": "To exclusively compile code to JavaScript",
          "answerId": 1,
          "id": 1,
          "correctAnswerId": 3
        },
        {
          "question": "How does Kotlin Multiplatform facilitate code sharing between platforms?",
          "answer": "By sharing business logic and adapting UI",
          "answerId": 2,
          "id": 2,
          "correctAnswerId": 2
        },
        {
          "question": "Which platforms does Kotlin Multiplatform support?",
          "answer": "Android, iOS, desktop and web",
          "answerId": 3,
          "id": 3,
          "correctAnswerId": 3
        },
        {
          "question": "What is a common use case for Kotlin Multiplatform?",
          "answer": "Developing a cross-platform app",
          "answerId": 2,
          "id": 4,
          "correctAnswerId": 2
        },
        {
          "question": "Which naming of KMP is deprecated?",
          "answer": "Kodee multiplatform",
          "answerId": 3,
          "id": 5,
          "correctAnswerId": 2
        },
        {
          "question": "How does Kotlin Multiplatform handle platform-specific implementations?",
          "answer": "By restricting to a single platform",
          "answerId": 4,
          "id": 6,
          "correctAnswerId": 1
        },
        {
          "question": "At which Google I/O, Google announced first-class support for Kotlin on Android?",
          "answer": "2017",
          "answerId": 4,
          "id": 7,
          "correctAnswerId": 4
        },
        {
          "question": "What is the name of the Kotlin mascot?",
          "answer": "Hadee",
          "answerId": 2,
          "id": 8,
          "correctAnswerId": 3
        },
        {
          "question": "The international yearly Kotlin conference is called...",
          "answer": "KConf",
          "answerId": 1,
          "id": 9,
          "correctAnswerId": 4
        },
        {
          "question": "Where will be located the next international yearly Kotlin conference?",
          "answer": "Amsterdam, Netherlands",
          "answerId": 3,
          "id": 10,
          "correctAnswerId": 1
        }
      ],
      "score": 4,
      "nickname": "user-140"
    }
""".trimIndent()


val json3 = """
    {
      "responses": [
        {
          "question": "What is the primary goal of Kotlin Multiplatform?",
          "answer": "To create iOS-only applications",
          "answerId": 1,
          "id": 1,
          "correctAnswerId": 2
        },
        {
          "question": "How does Kotlin Multiplatform facilitate code sharing between platforms?",
          "answer": "By sharing business logic and adapting UI",
          "answerId": 1,
          "id": 2,
          "correctAnswerId": 1
        },
        {
          "question": "Which platforms does Kotlin Multiplatform support?",
          "answer": "Android, iOS, desktop and web",
          "answerId": 1,
          "id": 3,
          "correctAnswerId": 1
        },
        {
          "question": "What is a common use case for Kotlin Multiplatform?",
          "answer": "Creating a server-side application",
          "answerId": 1,
          "id": 4,
          "correctAnswerId": 2
        },
        {
          "question": "Which naming of KMP is deprecated?",
          "answer": "Kodee multiplatform",
          "answerId": 1,
          "id": 5,
          "correctAnswerId": 3
        },
        {
          "question": "How does Kotlin Multiplatform handle platform-specific implementations?",
          "answer": "By excluding platform-specific features",
          "answerId": 1,
          "id": 6,
          "correctAnswerId": 4
        },
        {
          "question": "At which Google I/O, Google announced first-class support for Kotlin on Android?",
          "answer": "2017",
          "answerId": 1,
          "id": 7,
          "correctAnswerId": 1
        },
        {
          "question": "What is the name of the Kotlin mascot?",
          "answer": "Kotee",
          "answerId": 1,
          "id": 8,
          "correctAnswerId": 2
        },
        {
          "question": "The international yearly Kotlin conference is called...",
          "answer": "KodeeConf",
          "answerId": 1,
          "id": 9,
          "correctAnswerId": 3
        },
        {
          "question": "Where will be located the next international yearly Kotlin conference?",
          "answer": "Lille, France",
          "answerId": 1,
          "id": 10,
          "correctAnswerId": 3
        }
      ],
      "score": 3,
      "nickname": "user-717"
    }
""".trimIndent()

val json4 = """
    {
      "responses": [
        {
          "question": "What is the primary goal of Kotlin Multiplatform?",
          "answer": "To build only Android applications",
          "answerId": 1,
          "id": 1,
          "correctAnswerId": 4
        },
        {
          "question": "How does Kotlin Multiplatform facilitate code sharing between platforms?",
          "answer": "By writing separate code for each platform",
          "answerId": 1,
          "id": 2,
          "correctAnswerId": 3
        },
        {
          "question": "Which platforms does Kotlin Multiplatform support?",
          "answer": "Only web applications",
          "answerId": 1,
          "id": 3,
          "correctAnswerId": 3
        },
        {
          "question": "What is a common use case for Kotlin Multiplatform?",
          "answer": "Building a desktop-only application",
          "answerId": 1,
          "id": 4,
          "correctAnswerId": 4
        },
        {
          "question": "Which naming of KMP is deprecated?",
          "answer": "Kodee multiplatform",
          "answerId": 1,
          "id": 5,
          "correctAnswerId": 4
        },
        {
          "question": "How does Kotlin Multiplatform handle platform-specific implementations?",
          "answer": "By automatically translating code",
          "answerId": 1,
          "id": 6,
          "correctAnswerId": 4
        },
        {
          "question": "At which Google I/O, Google announced first-class support for Kotlin on Android?",
          "answer": "2017",
          "answerId": 1,
          "id": 7,
          "correctAnswerId": 1
        },
        {
          "question": "What is the name of the Kotlin mascot?",
          "answer": "Kotee",
          "answerId": 1,
          "id": 8,
          "correctAnswerId": 4
        },
        {
          "question": "The international yearly Kotlin conference is called...",
          "answer": "KotlinKonf",
          "answerId": 1,
          "id": 9,
          "correctAnswerId": 3
        },
        {
          "question": "Where will be located the next international yearly Kotlin conference?",
          "answer": "Lille, France",
          "answerId": 1,
          "id": 10,
          "correctAnswerId": 3
        },
        {
          "question": "What is the primary goal of Kotlin Multiplatform?",
          "answer": "To build only Android applications",
          "answerId": 1,
          "id": 1,
          "correctAnswerId": 4
        },
        {
          "question": "How does Kotlin Multiplatform facilitate code sharing between platforms?",
          "answer": "By writing separate code for each platform",
          "answerId": 1,
          "id": 2,
          "correctAnswerId": 3
        },
        {
          "question": "Which platforms does Kotlin Multiplatform support?",
          "answer": "Only web applications",
          "answerId": 1,
          "id": 3,
          "correctAnswerId": 3
        },
        {
          "question": "What is a common use case for Kotlin Multiplatform?",
          "answer": "Building a desktop-only application",
          "answerId": 1,
          "id": 4,
          "correctAnswerId": 4
        },
        {
          "question": "Which naming of KMP is deprecated?",
          "answer": "Kodee multiplatform",
          "answerId": 1,
          "id": 5,
          "correctAnswerId": 4
        },
        {
          "question": "How does Kotlin Multiplatform handle platform-specific implementations?",
          "answer": "By automatically translating code",
          "answerId": 1,
          "id": 6,
          "correctAnswerId": 4
        },
        {
          "question": "At which Google I/O, Google announced first-class support for Kotlin on Android?",
          "answer": "2017",
          "answerId": 1,
          "id": 7,
          "correctAnswerId": 1
        },
        {
          "question": "What is the name of the Kotlin mascot?",
          "answer": "Kotee",
          "answerId": 1,
          "id": 8,
          "correctAnswerId": 4
        },
        {
          "question": "The international yearly Kotlin conference is called...",
          "answer": "KotlinKonf",
          "answerId": 1,
          "id": 9,
          "correctAnswerId": 3
        },
        {
          "question": "Where will be located the next international yearly Kotlin conference?",
          "answer": "Lille, France",
          "answerId": 1,
          "id": 10,
          "correctAnswerId": 3
        }
      ],
      "score": 1,
      "nickname": "user-424"
    }
""".trimIndent()

fun Application.addSampleValues() {
    val data = listOf(json1, json2, json3, json4).map { json ->
        val q = Json.decodeFromString<QuizResponse>(json)
        QuizResponse(q.score, "user ${(1..1000).random()}", q.responses)
    }
    quizResponses.addAll(data)
}