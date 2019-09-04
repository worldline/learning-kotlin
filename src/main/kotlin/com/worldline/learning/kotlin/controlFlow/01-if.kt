package com.worldline.learning.kotlin.controlFlow

fun main(){
    val a = 20
    val b = 10

    // Traditional usage
    var max = a
    if (a < b) max = b

    // If is an expression in kotlin. This replaces the ternary operator in kotlin
    max = if (a > b) a else b

    // if branches can be blocks, and the last expression is the value of a block:
    max = if (a == b){
        print("Equal")
        a
    }else if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }
}