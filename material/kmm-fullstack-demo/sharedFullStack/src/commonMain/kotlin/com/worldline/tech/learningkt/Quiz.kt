package com.worldline.tech.learningkt

import kotlinx.serialization.Serializable

@Serializable
data class Quiz(var questions: List<Question>)
