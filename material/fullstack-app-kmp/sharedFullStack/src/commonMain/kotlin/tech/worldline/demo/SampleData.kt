package tech.worldline.demo

fun generateQuiz() = Quiz(listOf(
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
    )))