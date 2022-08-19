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

<!---
Author: Yassine BENABBAS
--->

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

<!---
Author: Yassine BENABBAS
--->

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

<!---
Author: Yassine BENABBAS
--->

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

<!---
Author: Yassine BENABBAS
--->

---

# Classes 2

```kotlin
data class Potion(var hp: Int){
    var timesConsumed = 0 // define member variable
    fun consume(){
        hp -= 20 ;  timesConsumed += 1 // avoid multi. statements on same line
    } // member function
} //data generates hashCode, equals, copy and toString
fun main(){
    val p1 = Potion(100)
    val p2 = Potion(80)
    println(p1 == p2) // false
    p1.consume() // call member function
    println(p1 == p2) // true even if timesConsumed !=
}
```

<!---
Author: Yassine BENABBAS
--->

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

<!---
Author: Yassine BENABBAS
--->

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

<!---
Author: Yassine BENABBAS
--->

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

<!---
Author: Yassine BENABBAS
--->

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

<!---
Author: Yassine BENABBAS
--->

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

<!---
Author: Yassine BENABBAS
--->

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

<!---
Author: Yassine BENABBAS
--->

---

# [Null safety](https://kotlinlang.org/docs/reference/null-safety.html)

```kotlin
fun main(){
    var s: String // vars must be initialized before using
    // println(s) -> compile fails
    s = "hello"
    println(s) // ok
    // s = null -> compile fails. Types are not nullable
    val msg : String? = null // nullable types
    println(msg)
    // msg.reversed() // msg may be null -> compile ko
    println(msg?.reversed()?.capitalize()) // return null if any part is null
    println(msg!!.reversed()) // tell compiler to ignore null checks -> NPE
}
```

<!---
Author: Yassine BENABBAS
--->

---

# [Null safety - part 2](https://kotlinlang.org/docs/reference/null-safety.html)

```kotlin
fun main(){
    var nb: Int? = 2
    // kotlin compiler known that nb is never null in else
    val double = if( nb == null ) 0 else nb * 2
    println(double)
    // shortcut of prev if using ?: elvis operator
    val triple = nb?.times(3) ?: 0 ; println(triple)
    //safe cast return nullable and does not throw exception
    val newNb = nb as? Long ;  println(newNb)
    // Convert nullable list to non nullable one
    val nullableList: List<Int?> = listOf(1, 2, null, 4)
	val intList: List<Int> = nullableList.filterNotNull()
    println(intList)
}
```

<!---
Author: Yassine BENABBAS
--->

---

# Java <-> Kotlin ineroperability

- Kotlin is designed with Java interoperability in mind
- Kotlin code may require annotation to be called from Java
- It is much more easier and natural to call Java from Kotli
  - For example: Java getter and Setter is converter to Kotlin propoerty

<!---
Author: Yassine BENABBAS
--->

---

# Java from Kotlin example

```kotlin
import java.util.*
fun convertToArrayList(source: List<Int>): ArrayList<Int> {
    // instantiate as in Java without 'new'
    val list = ArrayList<Int>()
    // 'for'-loops work for Java collections:
    for (item in source) list.add(item)
    // get and set are called
    for (i in 0..source.size - 1) list[i] = source[i]
    return list
}
fun main(){
    val list = convertToArrayList(listOf(0, 2, -1))
    println("list: ${list}. type: ${list::class.qualifiedName}")
    //list: [0, 2, -1]. type: java.util.ArrayList
}
```

<!---
Author: Yassine BENABBAS
--->

---

# Destructuring

```kotlin
// Destructuring allows to get different properties at once
data class Result(val code:Int, val message:String)
fun makeComputation():Result {
    return Result(200, "Success")
}
fun main(){
    // data class and Pair allows the following
    val (code, message) = makeComputation()
    println("code: ${code}. Message: ${message}")
    // works also on maps
    val map = mapOf(1 to "am", -1 to "stram", 5 to "gram")
    for((k,v) in map) println("key: ${k}, value: ${v}")
}
```

<!---
Author: Yassine BENABBAS
--->

---

# Function with receiver

```kotlin
fun produce(init: MilkProducer.() -> Unit): MilkProducer {
    val producer = MilkProducer()
    producer.init()
    return producer
}
class MilkProducer{
    val isSuccessful = false
    fun success(handler: MilkProducer.()-> Unit){
        if(isSuccessful) handler()
    }
    fun failure(handler: MilkProducer.()->Unit){
        if(!isSuccessful) handler()
    }
}
fun main(){
    produce {
        success { println("Success !") }
        failure { println("Failure !") }
    }
}
```

<!---
Author: Yassine BENABBAS
--->

---

# Kotlin for Android

- Kotlin simplifies Android development
- [Kotlin extensions](https://kotlinlang.org/docs/tutorials/android-plugin.html) eliminate the need to use `findViewById`
- _Note_: annotation dependencies are not the same than in Java
- Links:
  - [Getting started with Android and Kotlin](https://kotlinlang.org/docs/tutorials/kotlin-android.html)
  - [Kotlin Android Extensions ](https://kotlinlang.org/docs/tutorials/android-plugin.html)

# Coroutines

Requires maven dependency: org.jetbrains.kotlinx:kotlinx-coroutines-core

```kotlin
println("Start")
// Start a coroutine
GlobalScope.launch {
    delay(1000)
    println("Hello")
}
println("Stop")
```

This will crash

```kotlin
val c = AtomicLong()

for (i in 1..1_000_000L)
    thread(start = true) {
        c.addAndGet(i)
    }

println(c.get())
```

With coroutines it does not crash

```koltin
val c = AtomicLong()

for (i in 1..1_000_000L)
    GlobalScope.launch {
        c.addAndGet(i)
    }

println(c.get())
```

<!---
Author: Yassine BENABBAS
--->
