import csstype.ClassName
import csstype.px
import csstype.rgb
import emotion.react.css
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.ul
import react.useEffectOnce
import react.useState
import tech.worldline.demo.Question
import tech.worldline.demo.QuizAPI

private val scope = CoroutineScope(Dispatchers.Default)
private val quizApi = QuizAPI()

val QuizComponent = FC<Props> { props ->
    var questions by useState(emptyList<Question>())
    var isLoading by useState(true)

    useEffectOnce {
        scope.launch {
            questions = quizApi.getAllQuestions().questions
            delay(1000)
            isLoading = false
        }
    }
    if (isLoading) {
        div {
            className = ClassName("lds-dual-ring")
        }
    } else {
        h1 {
            css {
                padding = 5.px
                backgroundColor = rgb(8, 97, 22)
                color = rgb(56, 246, 137)
            }
            +"The quiz has ${questions.size} question(s)"
        }
        ul {
            questions.sortedByDescending { it.id }.forEach { q ->
                QuestionComponent {
                    question = q
                }
            }
        }
    }

}