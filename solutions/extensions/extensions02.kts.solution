package com.worldline.learning.kotlin.extensions

// The 'this' keyword inside an extension corresponds to the receiver object (the object that calls the extension)
// TODO ceeate an extension function 'makeQuestion' of the String class that return a new String that contains the original String + '?' at the end

// println("How do you do".makeQuestion()) // should print "How do you do ?"

// TODO define an extension function on the companion object that prints the number of created mages.
class Mage(hp: Int): Extensions01.Adventurer(hp){
    companion object {
        var count = 0
    }
    init {
        Mage.count += 1
    }
}
// hint: "this" allows to reference the companion object
fun Mage.Companion.printCount() = println(this.count)

val mage = Mage(100)
val mage2 = Mage(200)
print("Mage count: ")
Mage.printCount() // 2

// TODO crate an extension function "evenCount():Int" on List<Int> that return the number of even values

//println(listOf(1, 2, 3, 4, 5).evenCount()) // prints 2

// TODO create a generic extension function "concatenate():String" on List<T> that concatenates the toString value of all of the elements of the list
fun <T> List<T>.concatenate(): String = this.map { v -> v.toString() }.reduce { acc, s -> acc + s }
println(listOf("Hello ", "World", "Line").concatenate()) // should print "Hello WorldLine"
println(listOf(100, 200, 300).concatenate()) // should print "100200300"

// TODO create a generic extension function "List?.makeNotNull():List'  that return an empty list if the receiver is null, or the original list orherwise
fun <T> List<T>?.makeNotNull(): List<T>{
    return listOf<T>()
}
println(listOf(1, 2, 3).makeNotNull()) // should print [1, 2, 3]
val l: List<Int>? = null
println(l.makeNotNull()) // should print []