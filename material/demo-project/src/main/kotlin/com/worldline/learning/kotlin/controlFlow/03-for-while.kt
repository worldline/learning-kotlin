package com.worldline.learning.kotlin.controlFlow

fun main(){
    val collection = listOf("Hello", " ", "World", "Line")

    // loop trough collection
    for (item in collection) {
        print(item)
    }

    // iterate over numbers
    for (i in 1..3) {
        println(i)
    }
    for (i in 6 downTo 0 step 2) {
        println(i)
    }

    // iterate and get indices
    for (i in collection.indices) {
        println(collection[i])
    }

    // iterate with index and value
    for ((index, value) in collection.withIndex()) {
        println("the element at $index is $value")
    }

    // while is as ususal
    var x = 10
    while (x > 0) {
        x--
    }
}