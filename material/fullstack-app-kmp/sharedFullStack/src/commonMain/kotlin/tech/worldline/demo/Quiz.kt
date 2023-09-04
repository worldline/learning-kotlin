package tech.worldline.demo

import kotlinx.serialization.Serializable

@Serializable
data class Quiz(var questions: List<Question>)
