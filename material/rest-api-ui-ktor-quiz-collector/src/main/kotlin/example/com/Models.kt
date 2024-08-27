package example.com

import kotlinx.serialization.Serializable

@Serializable
data class QuestionResponse(
    val question: String,
    val answer: String,
    val id: Long,
    val answerId: Long,
    val correctAnswerId: Long
)

@Serializable
data class QuizResponse(val score: Int, val nickname: String, val responses: List<QuestionResponse>)

@Serializable
data class CollectResponse(val score: Int)

val quizResponses = mutableListOf<QuizResponse>()

// sample data with correct and wrong answers
val sampleResponses = listOf(
    QuizResponse(
        0, "user1",
        listOf(
            QuestionResponse(
                question = "What is the primary goal of Kotlin Multiplatform?",
                answer = "To share",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform facilitate code sharing between platforms?",
                "By sharing business logic and adapting UI",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                question = "Which platforms does Kotlin Multiplatform support?", answer = "Android, iOS, and web",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What is a common use case for Kotlin Multiplatform?", "Developing a cross-platform app",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What is a shared code module in Kotlin Multiplatform called?", "Shared module",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform handle platform-specific implementations?",
                "actual",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What languages can be interoperable with Kotlin Multiplatform?",
                "Java, Swift",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What tooling supports Kotlin Multiplatform development?",
                "IntelliJ IDEA",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What is the benefit of using Kotlin Multiplatform for mobile development?",
                "and sharing",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform differ from Kotlin Native and Kotlin/JS?",
                "None",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            )
        )
    ),
    QuizResponse(
        10, "user2",
        listOf(
            QuestionResponse(
                "What is the primary goal of Kotlin Multiplatform?",
                "To share code between multiple platforms",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform facilitate code sharing between platforms?",
                "By sharing business logic and adapting UI",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "Which platforms does Kotlin Multiplatform support?", "Android, iOS, and web",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What is a common use case for Kotlin Multiplatform?", "Developing a cross-platform app",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What is a shared code module in Kotlin Multiplatform called?", "Shared module",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform handle platform-specific implementations?",
                "Through expect and actual declarations",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What languages can be interoperable with Kotlin Multiplatform?",
                "Java, JavaScript, Swift",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What tooling supports Kotlin Multiplatform development?",
                "IntelliJ IDEA, Android Studio",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What is the benefit of using Kotlin Multiplatform for mobile development?",
                "Code reuse and sharing",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform differ from Kotlin Native and Kotlin/JS?",
                "Kotlin Multiplatform allows sharing code between different platforms using common modules.",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            )
        )
    ),
    QuizResponse(
        2, "user4",
        listOf(
            QuestionResponse(
                "What is the primary goal of Kotlin Multiplatform?",
                "To share code between multiple platforms",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform facilitate code sharing between platforms?",
                "By sharing business logic and adapting UI",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "Which platforms does Kotlin Multiplatform support?", "Android, iOS, and web",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What is a common use case for Kotlin Multiplatform?", "Developing a cross-platform app",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What is a shared code module in Kotlin Multiplatform called?", "Shared module",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform handle platform-specific implementations?",
                "Through expect and actual declarations",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What languages can be interoperable with Kotlin Multiplatform?",
                "Java, JavaScript, Swift",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What tooling supports Kotlin Multiplatform development?",
                "IntelliJ IDEA, Android Studio",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What is the benefit of using Kotlin Multiplatform for mobile development?",
                "Code reuse and sharing",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform differ from Kotlin Native and Kotlin/JS?",
                "Kotlin Multiplatform allows sharing code between different platforms using common modules.",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            )
        )
    ),
    QuizResponse(
        2, "user3",
        listOf(
            QuestionResponse(
                "What is the primary goal of Kotlin Multiplatform?",
                "To share code between multiple platforms",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform facilitate code sharing between platforms?",
                "By sharing business logic and adapting UI",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "Which platforms does Kotlin Multiplatform support?", "Android, iOS, and web",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What is a common use case for Kotlin Multiplatform?", "Developing a cross-platform app",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What is a shared code module in Kotlin Multiplatform called?", "Shared module",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform handle platform-specific implementations?",
                "Through expect and actual declarations",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What languages can be interoperable with Kotlin Multiplatform?",
                "Java, JavaScript, Swift",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What tooling supports Kotlin Multiplatform development?",
                "IntelliJ IDEA, Android Studio",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "What is the benefit of using Kotlin Multiplatform for mobile development?",
                "Code reuse and sharing",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform differ from Kotlin Native and Kotlin/JS?",
                "Kotlin Multiplatform allows sharing code between different platforms using common modules.",
                id = (1..10).random().toLong(),
                answerId = (1..4).random().toLong(),
                correctAnswerId = (1..4).random().toLong()
            )
        )
    ),
)