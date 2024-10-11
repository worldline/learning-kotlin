package com.worldline.training.ktor_quiz_collector.utils

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