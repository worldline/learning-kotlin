package example.com

import kotlinx.serialization.Serializable


val correctResponses = mapOf(
    "What is the primary goal of Kotlin Multiplatform?" to "To share code between multiple platforms",
    "How does Kotlin Multiplatform facilitate code sharing between platforms?" to "By sharing business logic and adapting UI",
    "Which platforms does Kotlin Multiplatform support?" to "Android, iOS, and web",
    "What is a common use case for Kotlin Multiplatform?" to "Developing a cross-platform app",
    "What is a shared code module in Kotlin Multiplatform called?" to "Shared module",
    "How does Kotlin Multiplatform handle platform-specific implementations?" to "Through expect and actual declarations",
    "What languages can be interoperable with Kotlin Multiplatform?" to "Java, JavaScript, Swift",
    "What tooling supports Kotlin Multiplatform development?" to "IntelliJ IDEA, Android Studio",
    "What is the benefit of using Kotlin Multiplatform for mobile development?" to "Code reuse and sharing",
    "How does Kotlin Multiplatform differ from Kotlin Native and Kotlin/JS?" to "Kotlin Multiplatform allows sharing code between different platforms using common modules."
)

@Serializable
data class QuestionResponse(val question: String, val answer: String)

@Serializable
data class QuizResponse(val responses: List<QuestionResponse>) {
    fun getScore(): Int {
        return responses.count { response -> correctResponses[response.question] == response.answer }
    }
}

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
        )
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
        )
    ),
)