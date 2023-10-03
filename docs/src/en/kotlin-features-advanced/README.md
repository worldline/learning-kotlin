# 📚 Advanced and other Kotlin features

## Delegated properties

Kotlin allows to delegate the getter and setter of a property to another object, which is called a delegate.
It is a class that defines the `getValue` and `setValue` methods.

Kotlin provides standard delegates such lazy properties and observable properties.

[:arrow_forward: this code](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbi5yYW5kb20uUmFuZG9tXG5pbXBvcnQga290bGluLnByb3BlcnRpZXMuRGVsZWdhdGVzXG5pbXBvcnQga290bGluLnJlZmxlY3QuS1Byb3BlcnR5XG5cbmNsYXNzIFN1cGVySGVybyB7XG4gICAgdmFsIHJhbmRvbVN0cmVuZ3RoOiBJbnQgYnkgbGF6eSB7XG4gICAgICAgIHByaW50bG4oXCJjb21wdXRlZFwiKVxuICAgICAgICBSYW5kb20ubmV4dEludCg1MCwgMTAwKVxuICAgIH1cbiAgICBcbiAgICB2YXIgcG93ZXJOYW1lOiBTdHJpbmcgYnkgRGVsZWdhdGVzLm9ic2VydmFibGUoXCJMYXNlclwiKSB7IF8sIG9sZCwgbmV3IC0+XG4gICAgICAgIHByaW50bG4oXCJDaGFuZ2VkIHBvd2VyIGZyb20gJG9sZCB0byAkbmV3XCIpXG4gICAgfVxuICAgIFxuICAgIHZhciBjb2RlTmFtZTogU3RyaW5nIGJ5IENhcGl0YWxpemVEZWxlZ2F0ZSgpXG59XG5cbmNsYXNzIENhcGl0YWxpemVEZWxlZ2F0ZXtcbiAgICB2YXIgdXBwZXJjYXNlZCA9IFwiXCJcbiAgICBvcGVyYXRvciBmdW4gZ2V0VmFsdWUodGhpc1JlZjogQW55PywgcHJvcGVydHk6IEtQcm9wZXJ0eTwqPik6IFN0cmluZyB7XG4gICAgICAgIHByaW50bG4oXCIkdGhpc1JlZiwgdGhhbmsgeW91IGZvciBkZWxlZ2F0aW5nICcke3Byb3BlcnR5Lm5hbWV9JyB0byBtZSFcIilcbiAgICAgICAgcmV0dXJuIHVwcGVyY2FzZWRcbiAgICB9XG5cbiAgICBvcGVyYXRvciBmdW4gc2V0VmFsdWUodGhpc1JlZjogQW55PywgcHJvcGVydHk6IEtQcm9wZXJ0eTwqPiwgdmFsdWU6IFN0cmluZykge1xuICAgICAgICBwcmludGxuKFwiJyR2YWx1ZScgaGFzIGJlZW4gYXNzaWduZWQgdG8gJyR7cHJvcGVydHkubmFtZX0nIGluICR0aGlzUmVmLlwiKVxuICAgICAgICB1cHBlcmNhc2VkID0gdmFsdWUudXBwZXJjYXNlKClcbiAgICB9XG59XG5cbmZ1biBtYWluKCkge1xuICAgdmFsIHN1cGVyTGFuZGVyID0gU3VwZXJIZXJvKClcbiAgIHByaW50bG4oc3VwZXJMYW5kZXIucmFuZG9tU3RyZW5ndGgpXG4gICBwcmludGxuKHN1cGVyTGFuZGVyLnJhbmRvbVN0cmVuZ3RoKVxuICAgXG4gICBzdXBlckxhbmRlci5wb3dlck5hbWUgPSBcInNwZWVkXCJcbiAgICBcbiAgICBzdXBlckxhbmRlci5jb2RlTmFtZSA9IFwic3VwZXJsYW5kZXJcIlxuICAgIHByaW50bG4oc3VwZXJMYW5kZXIuY29kZU5hbWUpXG59In0=) illustrates delegate properties.

## Concurrency and Coroutines

Kotlin provides a high level concurrency model called _Coroutines_.
The developer can delegated the management of threads to the compiler and runtime and using higher level constructs than threads to express asynchronous operations.

Coroutines in Kotlin revolve around these concepts:

- A coroutine is an instance of suspendable computation.
  - Kotlin has many methods for creating a coroutine such as `launch`.
- A coroutine must exist within a coroutine scope.
  - For example `runBlocking` creates a coroutine scope whithin which coroutines can be launched.
- A coroutine can run suspend functions which can suspend the coroutine but do not block the thread.
  - For example: the `delay` suspend the coroutine but does not block the thread on which it is running.
  - Suspend functions are operations that may take time such http requests and file system calls.
- The `suspend` qualifier defines a suspend function. It runs within a coroutine and can call other suspend functions.
- `Flow` allows to generate a list of asynchronous values.
- `Deferred` and `Channel` transfer a single value and a stream of values, respectively, between coroutines.

[:arrow_forward: this code](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbnguY29yb3V0aW5lcy4qXG5cbnN1c3BlbmQgZnVuIHJ1blNvbWV0aGluZygpIHtcbiAgICBwcmludGxuKFwic3RhcnRpbmdcIilcbiAgICBkZWxheSg1MDApXG4gICAgcHJpbnRsbihcImZpbmlzaGVkXCIpXG59XG5cbi8vIHJ1bkJsb2NraW5nIGNyZWF0ZXMgYSBDb3JvdXRpbmVTY29wZVxuZnVuIG1haW4oKSA9IHJ1bkJsb2NraW5nIHsgXG4gICAgLy8gbGF1bmNoIGEgbmV3IGNvcm91dGluZVxuICAgIGxhdW5jaCB7IFxuICAgICAgICAvLyBTdXNwZW5kIHRoZSBjb3JvdXRpbmUgYnV0IGRvZXMgbm90IGJsb2NrIHRoZSB0aHJlYWRcbiAgICAgICAgZGVsYXkoMTAwMEwpIFxuICAgICAgICBwcmludGxuKFwiV29ybGQhXCIpIFxuICAgIH1cbiAgICAgICAgXG4gICAgLy8gbWFpbiBjb3JvdXRpbmUgY29udGludWVzIHdoaWxlIGEgcHJldmlvdXMgb25lIGlzIGRlbGF5ZWRcbiAgICBwcmludGxuKFwiSGVsbG9cIikgXG4gICAgXG4gICAgdmFsIGpvYiA9IGxhdW5jaCB7XG4gICAgICAgIHJ1blNvbWV0aGluZygpXG4gICAgfVxuICAgIGpvYi5qb2luKClcbiAgICBydW5Tb21ldGhpbmcoKVxuICAgIFxufSJ9) show how to create a coroutine and suspend function and how to use them.

[:arrow_forward: this code](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbnguY29yb3V0aW5lcy4qXG5pbXBvcnQga290bGlueC5jb3JvdXRpbmVzLmZsb3cuKlxuXG5mdW4gZ2VucmF0ZUFzeW5jUmFuZG9tVmFsdWVzKCk6IEZsb3c8SW50PiA9IGZsb3cgeyBcbiAgICBwcmludGxuKFwiRmxvdyBzdGFydGVkXCIpXG4gICAgZm9yIChpIGluIDAuLjEwKSB7XG4gICAgICAgIGRlbGF5KDEwMClcbiAgICAgICAgZW1pdChpKVxuICAgIH1cbn1cblxuLy8gVGhpcyBjYW4gY2F1c2UgcHJvYmxlbXMgaW4gbm90IGhhbmRsZWRlZCBjb3JyZWN0bHlcbmZ1biBnZW5yYXRlQXN5bmNSYW5kb21WYWx1ZXNJbmZpbml0ZSgpOiBGbG93PEludD4gPSBmbG93IHsgXG4gICAgcHJpbnRsbihcIkZsb3cgc3RhcnRlZFwiKVxuICAgIHZhciBpID0gMFxuICAgIHdoaWxlICh0cnVlKSB7XG4gICAgICAgIGRlbGF5KDEwMClcbiAgICAgICAgZW1pdChpKVxuICAgICAgICBpICs9IDFcbiAgICB9XG59XG5cblxuXG4vLyBydW5CbG9ja2luZyBjcmVhdGVzIGEgQ29yb3V0aW5lU2NvcGVcbmZ1biBtYWluKCkgPSBydW5CbG9ja2luZzxVbml0PiB7XG4gICAgbGF1bmNoe1xuICAgICAgICBnZW5yYXRlQXN5bmNSYW5kb21WYWx1ZXMoKS5jb2xsZWN0IHtcbiAgICAgICBcdFx0cHJpbnRsbihcIjFzdCBmbG93OiBHb3QgJGl0XCIpXG4gICBcdFx0fVxuICAgIH1cbiAgIFxuICAgbGF1bmNoe1xuICAgICAgIHdpdGhUaW1lb3V0T3JOdWxsKDEwMDApe1xuICAgICAgICAgICBnZW5yYXRlQXN5bmNSYW5kb21WYWx1ZXMoKS5jb2xsZWN0IHtcbiAgICAgICAgICAgcHJpbnRsbihcIjJuZCBmbG93OiBHb3QgJGl0XCIpXG4gICAgICAgICB9XG4gICAgICAgfVxuICAgfVxufSJ9) illustrated flows.

[:arrow_forward: this code](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbnguY29yb3V0aW5lcy4qXG5pbXBvcnQga290bGlueC5jb3JvdXRpbmVzLmNoYW5uZWxzLipcblxuZnVuIG1haW4oKSA9IHJ1bkJsb2NraW5nIHtcbiAgICBcbiAgICAvLyBhc3luYyBsYXVuY2hlcyBhIGNvcm91dGluZXMgYW5kIHJldHVybnMgYSBEZWZlcnJlZDxJbnQ+XG4gICAgdmFsIGRlZmVycmVkID0gYXN5bmMge1xuICAgICAgICA0MlxuICAgIH1cbiAgICBwcmludGxuKGRlZmVycmVkLmF3YWl0KCkpXG5cbiAgICB2YWwgY2hhbm5lbCA9IENoYW5uZWw8SW50PigpXG4gICAgbGF1bmNoIHtcbiAgICAgICAgLy8gdGhpcyBtaWdodCBiZSBoZWF2eSBDUFUtY29uc3VtaW5nIGNvbXB1dGF0aW9uIG9yIGFzeW5jIGxvZ2ljLCB3ZSdsbCBqdXN0IHNlbmQgZml2ZSBzcXVhcmVzXG4gICAgICAgIGZvciAoeCBpbiAxLi41KSBjaGFubmVsLnNlbmQoeCAqIHgpXG4gICAgfVxuICAgIC8vIGhlcmUgd2UgcHJpbnQgZml2ZSByZWNlaXZlZCBpbnRlZ2VyczpcbiAgICByZXBlYXQoNSkgeyBwcmludGxuKGNoYW5uZWwucmVjZWl2ZSgpKSB9XG4gICAgcHJpbnRsbihcIkRvbmUhXCIpXG5cbn0ifQ==) illustrates channels and deferred.

## Function literal with receiver and Type-safe builders

As seen previously, function extension add behavior to existing classes.
Inside the definition of the function extension, we can reference the **extension receiver** (or this) implicitly.

```kotlin
fun String.countCharacters() = length // or this.length
println("hello".countCharacters()) // prints 5
```

We can define this extension with a function literal (or lambda) in instead of a named function (declared with `fun`).

```kotlin
var extFn: String.() -> Int
extFn = { length } // extFn is a function literal
println("hello".extFn()) // prints 5
println(extFn("hello")) // prints 5
```

`extFn` **is a function literal** (lambda) that has access to the **receiver** (this).
That's why it's called a **function literal with receiver**.

`extFn("hello")` or `extFn("hello")` call the extension as expected from extension functions.

The type of a function literal with receiver is `funName: ReceiverType.(arg1Type, arg2Type, etc.) -> ReturnType` and is called with `funName(receiverValue, arg1Value, etc.)` or `receiverValue.funName(arg1Value, etc.)`. However, this is not the interesting aspect.

The important part is `extFn = { length }` which can be put as a function argument in a higher order function.
The developer that calls the higher order function must define `extFn`, which in turn has access to the receiver.
This allows for a nice style of programming.
[:arrow_forward: this code](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbi5yYW5kb20uUmFuZG9tXG5cbmZ1biBtYWluKCkge1xuICAgIC8vIGZuIGlzIGEgZnVuY3Rpb24gbGl0ZXJhbHMgd2l0aCByZWNlaXZlciB0aGF0IHJldHVybnMgYW4gaW50XG4gICAgZnVuIGRvU29tZXRoaW5nV2l0aFJhbmRvbUludChmbjogSW50LigpIC0+IEludCk6IEludCB7XG4gICAgXHR2YWwgcmFuZG9tSW50ID0gUmFuZG9tLm5leHRJbnQoMzIsIDk4KVxuICAgIFx0cmV0dXJuIHJhbmRvbUludC5mbigpXG5cdH1cbiAgICAgXG4gICAgdmFsIHJlc3VsdCA9IGRvU29tZXRoaW5nV2l0aFJhbmRvbUludCB7XG4gICAgICAgIC8vIFRoZSByZWNlaXZlciBpcyBpbXBsaWNpdGx5IGF2YWlsYWJsZSBpbiB0aGlzIGxhbWJkYVxuICAgICAgICBwcmludGxuKFwidGhpczogJHRoaXNcIilcbiAgICAgICAgcHJpbnRsbihcInBsdXM6ICR7cGx1cygxMDApfVwiKVxuICAgICAgICBtaW51cyg1MDApXG4gICAgfVxuICAgIHByaW50bG4oXCJyZXN1bHQgOiAkcmVzdWx0XCIpXG59In0=) shows an example.

[**Type-safe builders**](https://kotlinlang.org/docs/type-safe-builders.htmlhttps://kotlinlang.org/docs/type-safe-builders.html) combine well-named builder functions and functions literals with receiver to create type-safe, statically typed builders in Kotlin.

::: tip Builder pattern
[The builder pattern](https://refactoring.guru/design-patterns/builder) is a way to construct complex objects.

```kotlin
// StirngBuilder uses the builder pattern
val text = StringBuilder("Temp")
  .append(1)
  .append(true)
  .append("friend")
  .toString()
```

:::

[This code shows](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiY2xhc3MgTWlsa3tcbiAgICB2YXIgYnJhbmQ6IFN0cmluZyA9IFwiXCJcbiAgICB2YXIgcXVhbnRpdHk6IEludCA9IDBcbiAgICBmdW4gYnJhbmQoaGFuZGxlcjogTWlsay4oKS0+IFN0cmluZyl7XG4gICAgICAgIGJyYW5kID0gaGFuZGxlcigpXG4gICAgfVxuICAgIGZ1biBxdWFudGl0eShoYW5kbGVyOiBNaWxrLigpLT5JbnQpe1xuICAgICAgICBxdWFudGl0eSA9IGhhbmRsZXIoKVxuICAgIH1cbiAgICBvdmVycmlkZSBmdW4gdG9TdHJpbmcoKSA9IFwiJHF1YW50aXR5IEwgb2YgbWlsayBmcm9tICRicmFuZFwiXG59XG5cbi8vIHR5cGVzYWZlIGJ1aWxkZXIgZW50cnkgcG9pbnRcbmZ1biBwcm9kdWNlTWlsayhpbml0OiBNaWxrLigpIC0+IFVuaXQpOiBNaWxrIHtcbiAgICB2YWwgbWlsayA9IE1pbGsoKVxuICAgIG1pbGsuaW5pdCgpXG4gICAgcmV0dXJuIG1pbGtcbn1cblxuZnVuIG1haW4oKXtcbiAgICB2YWwgbWlsayA9IHByb2R1Y2VNaWxrIHtcbiAgICAgICAgYnJhbmQgeyBcIlN1cGVyIG1pbGtcIiB9XG4gICAgICAgIHF1YW50aXR5IHsgMTAwIH1cbiAgICB9XG4gICAgcHJpbnRsbihtaWxrKVxufSJ9) a basic type-safe builder.

[Kotlin docs](https://kotlinlang.org/docs/type-safe-builders.html) provides an example of an advanced type-safe builder that builds an HTML page.

## 🧪 Exercises

#### Exercise 1

1. open the **java-integration-exercise** projects in the **materials** folder.
1. Have a look at the Java class we provided you in the `src/main/java/com/worldline/learning/kotlin/java2kotlin` package. _(yes, that's the Pokemon class)_
1. Convert that Java class in Kotlin using IntelliJ's awesome copy-pasta tool! _(just copy paste the java code in a kotlin file, one is provided at `src/main/kotlin/com/worldline/learning/kotlin/java2kotlin`)_
1. Have a look at the generated Kotlin code, and note the major differences you spot!
