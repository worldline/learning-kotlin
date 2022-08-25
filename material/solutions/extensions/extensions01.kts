package com.worldline.learning.kotlin.extensions

// Extensions allows to add functions or properties to an existing class (even classes imported from other libraries)
// https://kotlinlang.org/docs/reference/extensions.html

open class Adventurer(var hp: Int){
    val maxHp = hp
    fun attack():String = "I dealt 10 damage"
}
// Extension function syntax: fun className.functionName(prams) : returnType
fun Adventurer.reportStatus():String {
    return "I have ${hp} HP"
}
// TODO create an adventurer with 200hp and print the result of the reportStatus extension method

fun Adventurer.attack():String = "I dealt 1000 damage"
// TODO print the result of the attack function. Which version is retained (member fun or extension fun ?)

// TODO overload fun 'attack():String' with the extesntion fun 'Adventurer.attack(damage: Int):String' that prints the value passed as a parameter

// TODO print the results of this new extension function with parameter values 50, 10 and 200

// TODO what is the result of printStatus on a Barbarian ? what do you conclude ?
class Barbarian(hp: Int): Adventurer(hp)
fun Barbarian.reportStatus():String = "I am a barbarian and I have ${hp} HP"
fun printStatus(adventurer: Adventurer) {
    println(adventurer.reportStatus())
}
val barbarian= Barbarian(500)
printStatus(barbarian)

// TODO create an extension property "lostHp" that corresponds to "maxHp - hp" .
//  Because we cannot add fields to an existing class, extension properties can be defined using getters and setters.
var Barbarian.lostHp:Int
    get() = maxHp - hp
    set (value) { hp = maxHp - value}

val b = Barbarian(300)
b.hp -= 100
println(b.lostHp) // 100
b.lostHp = 250
println(b.hp) // 50
