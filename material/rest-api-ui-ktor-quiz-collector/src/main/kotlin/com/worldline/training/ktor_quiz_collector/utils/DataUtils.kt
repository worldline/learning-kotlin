package com.worldline.training.ktor_quiz_collector.utils

import kotlinx.serialization.Serializable
import org.jetbrains.kotlinx.dataframe.api.dataFrameOf
import org.jetbrains.kotlinx.dataframe.api.sortByDesc
import org.jetbrains.kotlinx.dataframe.api.toDataFrame
import org.jetbrains.kotlinx.kandy.dsl.continuous
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.ir.Plot
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.bars
import org.jetbrains.kotlinx.kandy.letsplot.layers.barsH
import org.jetbrains.kotlinx.kandy.letsplot.scales.categoricalColorHue
import org.jetbrains.kotlinx.kandy.letsplot.x
import org.jetbrains.kotlinx.kandy.letsplot.y
import org.jetbrains.kotlinx.kandy.util.color.Color

@Serializable
data class QuestionStats(val question: String, val correct: Int)

fun getCorrectStats() =
    com.worldline.training.ktor_quiz_collector.utils.quizResponses.flatMap { it.responses }.groupBy { it.question }
        .mapValues { it.value.count { qr -> qr.correctAnswerId == qr.answerId } }
        .map {
            com.worldline.training.ktor_quiz_collector.utils.QuestionStats(
                it.key.take(10) + "..." + it.key.takeLast(
                    10
                ), it.value
            )
        }

fun generateCorrectQuestionsPlot(): Plot {
    val correctStats = com.worldline.training.ktor_quiz_collector.utils.getCorrectStats()
    val statsDataFrame = dataFrameOf("question" to correctStats.map { it.question },
        "correct" to correctStats.map { it.correct })
    val responseCount = if (quizResponses.isEmpty()) 0 else quizResponses[0].responses.size
    return statsDataFrame.plot {
        layout {
            title = "Correct Answers"
            xAxisLabel = "Total correct answers"
            yAxisLabel = "Question"
        }
        y("question")
        barsH {
            x.constant(responseCount)
            width = 0.5
            fillColor = Color.GREY
            alpha = 0.3
        }
        barsH {
            y("question")
            x("correct")
            fillColor("question") {
                scale = categoricalColorHue()
            }
        }
    }
}

fun generateLeaderBoardPlot(): Plot {
    val userScores = mapOf("user" to quizResponses.map { it.nickname },
        "score" to quizResponses.map { it.score })
    val rowCount = quizResponses.count()
    val maxScore = quizResponses.maxOfOrNull { it.score } ?: 0
    val df = if (rowCount > 0) userScores.toDataFrame().sortByDesc("score") else userScores.toDataFrame()
    return plot(df) {
        layout {
            title = "Leaderboard"
            xAxisLabel = "Nickame"
            yAxisLabel = "Score"
            size = 1200 to 600
        }
        x("user")
        bars {
            y.constant(maxScore)
            width = 0.5
            fillColor = Color.GREY
            alpha = 0.3
        }
        bars {
            y("score") {
                scale = continuous(0..maxScore)
            }
            x("user")
            if (rowCount > 2) {
                fillColor("user") {
                    scale = categoricalColorHue()
                }
            }

        }
    }
}