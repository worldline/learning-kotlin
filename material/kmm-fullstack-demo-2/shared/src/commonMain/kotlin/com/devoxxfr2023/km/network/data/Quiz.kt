package com.devoxxfr2023.km.network.data

import kotlinx.serialization.Serializable

@Serializable
data class Quiz(var questions: List<Question>)
