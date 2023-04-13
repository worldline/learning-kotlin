import io.ktor.client.*
import kotlinx.coroutines.runBlocking
import tech.worldline.demo.QuizAPI

fun main() {
    runBlocking {
        val quizApi = QuizAPI(HttpClient((CIO)))
        val quiz = quizApi.getAllQuestions()
        print(quiz)
    }
}