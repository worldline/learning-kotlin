package example.com


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

data class QuestionResponse(val question: String, val answer: String)
data class QuizResponse(val responses: List<QuestionResponse>) {
    val score: Int = responses.count { response -> correctResponses[response.question] == response.answer }
    val histogram: Map<String, Int> = responses.groupingBy { it.answer }.eachCount()
}