import react.FC
import react.Props
import react.dom.html.ReactHTML
import tech.worldline.demo.Question

external interface QuestionProps : Props {
    var question: Question
}

val QuestionComponent = FC<QuestionProps> { props ->
    val question = props.question
    ReactHTML.li {
        +question.label
        ReactHTML.ul {
            question.answers.sortedByDescending { it.id }.forEach { answer ->
                ReactHTML.li {
                    +answer.label
                }
            }
        }
    }
}