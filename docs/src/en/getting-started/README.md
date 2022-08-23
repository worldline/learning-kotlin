
## Naive forEach implementation

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


## Destructuring

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

## Function with receiver

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

## Kotlin for Android

- Kotlin simplifies Android development
- [Kotlin extensions](https://kotlinlang.org/docs/tutorials/android-plugin.html) eliminate the need to use `findViewById`
- _Note_: annotation dependencies are not the same than in Java
- Links:
  - [Getting started with Android and Kotlin](https://kotlinlang.org/docs/tutorials/kotlin-android.html)
  - [Kotlin Android Extensions ](https://kotlinlang.org/docs/tutorials/android-plugin.html)

## Coroutines

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

```kotlin
val c = AtomicLong()

for (i in 1..1_000_000L)
    GlobalScope.launch {
        c.addAndGet(i)
    }

println(c.get())
```