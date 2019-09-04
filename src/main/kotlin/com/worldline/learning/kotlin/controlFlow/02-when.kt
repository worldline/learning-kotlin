package com.worldline.learning.kotlin.controlFlow

import javax.xml.bind.DatatypeConverter.parseInt
import kotlin.math.absoluteValue

fun main(){

    val x = 65

    // equivalent of switch expressions. This is a simple example
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> { // Note the block
            print("x is neither 1 nor 2")
        }
    }

    // Like if, when is an expression
    var result = when (x) {
        1 -> "x == 1"
        2 -> "x == 2"
        else -> "x is neither 1 nor 2"
    }
    println(result)

    // combining cases
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }

    val s = "65"
    // we can use expressions in cases
    when (x) {
        parseInt(s) -> print("$s encodes $x")
        else -> print("s does not encode x")
    }


    // we can check a value being in a range or collection
    val validNumbers = listOf(11, 12)
    when (x) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }

    val y:Any = 12
    // we can use is for type checking + smartcast inside the breanch
    val hasPrefix = when(y) {
        is String -> y.startsWith("prefix")
        else -> false
    }
    println("has prefix $hasPrefix")

    // when can be used as a replacement to if - eslse
    when {
        x % 2 == 0 -> println("x is odd")
        x.absoluteValue  > 10 -> println("abs x is odd and > 10")
        else -> println("x is funny")
    }

    // we can capture the subject in a variable
    when (val first = listOf(10, 11, 22, 33).first()){
        in 1..100 -> println("first in interval. Its value is $first")
        else -> println("$first is funny")
    }
}