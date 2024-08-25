package example.com

import kotlinx.serialization.Serializable

@Serializable
data class QuestionResponse(
    val question: String,
    val answer: String,
    val id: Long = (1..100).random().toLong(),
    val anwserId: Long = (1..4).random().toLong(),
    val correctAnwserId: Long = (1..4).random().toLong()
)

@Serializable
data class QuizResponse(val responses: List<QuestionResponse>, val score: Int, val nickname: String)

@Serializable
data class CollectResponse(val score: Int)

val quizResponses = mutableListOf<QuizResponse>()

// sample data with correct and wrong answers
val sampleResponses = listOf(
    QuizResponse(
        listOf(
            QuestionResponse(
                "What is the primary goal of Kotlin Multiplatform?",
                "To share"
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform facilitate code sharing between platforms?",
                "By sharing business logic and adapting UI"
            ),
            QuestionResponse("Which platforms does Kotlin Multiplatform support?", "Android, iOS, and web"),
            QuestionResponse("What is a common use case for Kotlin Multiplatform?", "Developing a cross-platform app"),
            QuestionResponse("What is a shared code module in Kotlin Multiplatform called?", "Shared module"),
            QuestionResponse(
                "How does Kotlin Multiplatform handle platform-specific implementations?",
                "actual"
            ),
            QuestionResponse(
                "What languages can be interoperable with Kotlin Multiplatform?",
                "Java, Swift"
            ),
            QuestionResponse(
                "What tooling supports Kotlin Multiplatform development?",
                "IntelliJ IDEA"
            ),
            QuestionResponse(
                "What is the benefit of using Kotlin Multiplatform for mobile development?",
                "and sharing"
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform differ from Kotlin Native and Kotlin/JS?",
                "None"
            )
        ), 0, "user1"
    ),
    QuizResponse(
        listOf(
            QuestionResponse(
                "What is the primary goal of Kotlin Multiplatform?",
                "To share code between multiple platforms"
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform facilitate code sharing between platforms?",
                "By sharing business logic and adapting UI"
            ),
            QuestionResponse("Which platforms does Kotlin Multiplatform support?", "Android, iOS, and web"),
            QuestionResponse("What is a common use case for Kotlin Multiplatform?", "Developing a cross-platform app"),
            QuestionResponse("What is a shared code module in Kotlin Multiplatform called?", "Shared module"),
            QuestionResponse(
                "How does Kotlin Multiplatform handle platform-specific implementations?",
                "Through expect and actual declarations"
            ),
            QuestionResponse(
                "What languages can be interoperable with Kotlin Multiplatform?",
                "Java, JavaScript, Swift"
            ),
            QuestionResponse(
                "What tooling supports Kotlin Multiplatform development?",
                "IntelliJ IDEA, Android Studio"
            ),
            QuestionResponse(
                "What is the benefit of using Kotlin Multiplatform for mobile development?",
                "Code reuse and sharing"
            ),
            QuestionResponse(
                "How does Kotlin Multiplatform differ from Kotlin Native and Kotlin/JS?",
                "Kotlin Multiplatform allows sharing code between different platforms using common modules."
            )
        ),
        10, "user2"
    ),
)