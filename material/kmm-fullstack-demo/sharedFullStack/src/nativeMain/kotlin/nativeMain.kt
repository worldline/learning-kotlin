import io.ktor.client.*
import io.ktor.client.engine.winhttp.*
import kotlinx.coroutines.runBlocking
import tech.worldline.demo.QuizAPI

fun main() {
    runBlocking {
        val quizApi = QuizAPI(HttpClient((WinHttp)))
        val quiz = quizApi.getAllQuestions()
        print(quiz)
    }
}