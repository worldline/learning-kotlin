title: Learning Kotlin - Getting Started!
class: animation-fade
layout: true

<!-- This slide will serve as the base layout for all your slides -->

.bottom-bar[]

---

class: impact

![](assets/kotlin_logo.png)

---

class: impact

# Getting Started!

Kotlin is an object oriented langiage with functional features

---

# Variables

```kotlin
var a: Int = 0 // variable
a = 23

val b: String = "Hello" // immutable variable
b = "World" //error

var b = "Hello" // Type is inferred
```

- Use val as much as possible
- _In kotlin, semi-colons are optionnal_

---

# Functions

```kotlin
// Functions can be declared outside of classes
fun sum(x:Int, y:Int) : Int {
    return x + y
} // function definition

//One line function
fun mult(x:Int, y: Int) = x * y

fun main(argv:Array<String>){
    val a = sum(2, 1) // call sum function
    println(mult(a, y = 8)) // we can name parameters
}
```

---

# Functions arguments

```kotlin
fun greet(year: Int = 2018, month: Int = 1,
          message: String = "Hello") : String {
    return "${message}. We are in ${month}/${year}"
}

fun main(argv:Array<String>){
    println(greet(2017, 10, "Bonjour")) //Bonjour. We are in 10/2017
    println(greet()) //Hello. We are in 1/2018
    println(greet(2018, message = "Konnichiwa"))
    //Konnichiwa. We are in 1/2018
}
```

---

# Classes

```kotlin
open class Pokemon // class with default constructor
class PokemonTrainer(val name: String, val pokemon: Pokemon)

// classes are final by default. Open allows to inherit
class Pikachu(val Watts: Int) : Pokemon()

fun main(){
    val pika = Pikachu(2000) // type inferred
    val ash = PokemonTrainer("ash", pika)
    println("${ash.name}, your pokemon object is $pika")
    // ash, your pokemon object is Pikachu@2ff4acd0
}
```

---

# Classes 2

```kotlin
data class Potion(var hp: Int){
    var timesConsumed = 0 // define member variable
    fun consume(){
        hp -= 20 ;  timesConsumed += 1 // avoid multi. statements on same line
    } // member function
} //data generates hash code + equals
fun main(){
    val p1 = Potion(100)
    val p2 = Potion(80)
    println(p1 == p2) // false
    p1.consume() // call member function
    println(p1 == p2) // true even if timesConsumed !=
}
```

---

# Control flow

```kotlin
fun main(){
    var n = 2
    var isPair = if ( n % 2 == 0 ){
        true
    }else{
        false
    } // If statements can return a value
    println(isPair)
    n = 11
    isPair = if( n % 2 == 0) true else false
    println(isPair)
}
```

---

# Control flow : when

```kotlin
fun main(){
    val greeting = "Bonjour"
    // when is a more powerful switch
    // It works also on strings
    val language = when(greeting){
       "Bonjour","salut" -> "Français"
        "Good morning" -> "English"
        else -> "Unknown"
    }
    println(language) // Français
}
```

---

# Control flow: loops

```kotlin
fun main(){
    for (i in 1..3) println(i) // single line
	for (i in 6 downTo 0 step 2) println(i)
    for (msg in arrayOf("Hello", "world")) {
    	println(msg)
	}
    var x = 2
    while (x > 0) {
    	x--
	}
}
```

---

# Higher order functions

```kotlin
fun calculate(x: Int, y: Int, f: (Int, Int) -> Int) : Int{
    return f(x, y)
} // calculate takes a function as a paramter
fun sum(x: Int, y: Int) = x + y
fun main(){
    println(calculate(9, 5, ::sum)) // 14
    val f = {x: Int, y: Int -> x - y}
    println(calculate(9, 5, f)) // 4
    println(calculate(9, 5, { x, y -> x * y } )) // 45
    // If the last parameter is function, we can close () erlier
    println(calculate(9, 5) { x, y -> x * y } ) // 45
}
```

---

# Naive forEach implementation

```kotlin
// Unit means no return value (it is optionnal)
fun naiveForEach(items: List<Int>, f: (Int) -> Unit){
    for(item in items) f(item)
} // Naive implementation of forEeach
fun main(){
    val numbers = listOf(1, 3, 5, -1)
    naiveForEach(numbers) {
        println(it * 10)
    } // The it parameter is implcit for signle arg fun

    // Kotlin defines a forEach method for collections
    numbers.forEach { println(it * 100) }
}
```

---

# Extensions

```kotlin
// we can extend existing classes with functions
fun String.makeQuestion() = this + " ?"
// And getters / setters
val Int.isPair get() = this % 2 == 0
fun main(){
    val s = "Are you OK"
    val q = s.makeQuestion()
    println("s: ${s}, q: ${q}")
    // s: Are you OK, q: Are you OK ?
    println(2.isPair) // true
}
```

---
