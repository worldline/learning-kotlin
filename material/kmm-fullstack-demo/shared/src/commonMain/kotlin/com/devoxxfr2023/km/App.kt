package com.devoxxfr2023.km

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.devoxxfr2023.km.network.QuizRepository


private val repository = QuizRepository()


@Composable
internal fun App() {
    MaterialTheme {

        /*var questions = listOf(
            Question(
                1,
                "Android is a great platform ?",
                1,
                listOf(Answer(1, "YES"), Answer(2, "NO"))
            ),
            Question(
                1,
                "Android is a bad platform ?",
                2,
                listOf(Answer(1, "YES"), Answer(2, "NO"))
            )
        )*/

        /*val questions = repository.questionState.collectAsState()

        if(questions.value.isNotEmpty()) {
            questionScreen(questions.value)
        }*/
        rootNavHost()


    }

}