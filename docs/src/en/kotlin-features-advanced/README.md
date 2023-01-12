# Fonctionnalités avancées de Kotlin

## Propriétés déléguées

Kotlin permet de déléguer le getter et le setter d'une propriété à un autre objet, appelé délégué.
C'est une classe qui définit les méthodes `getValue` et `setValue`.

Kotlin fournit des délégués standard tels que des propriétés paresseuses et des propriétés observables.

[:arrow_forward: this code](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbi5yYW5kb20uUmFuZG9tXG5pbXBvcnQga290bGluLnByb3BlcnRpZXMuRGVsZWdhdGVzXG5pbXBvcnQga290bGluLnJlZmxlY3QuS1Byb3BlcnR5XG5cbmNsYXNzIFN1cGVySGVybyB7XG4gICAgdmFsIHJhbmRvbVN0cmVuZ3RoOiBJbnQgYnkgbGF6eSB7XG4gICAgICAgIHByaW50bG4oXCJjb21wdXRlZFwiKVxuICAgICAgICBSYW5kb20ubmV4dEludCg1MCwgMTAwKVxuICAgIH1cbiAgICBcbiAgICB2YXIgcG93ZXJOYW1lOiBTdHJpbmcgYnkgRGVsZWdhdGVzLm9ic2VydmFibGUoXCJMYXNlclwiKSB7IF8sIG9sZCwgbmV3IC0+XG4gICAgICAgIHByaW50bG4oXCJDaGFuZ2VkIHBvd2VyIGZyb20gJG9sZCB0byAkbmV3XCIpXG4gICAgfVxuICAgIFxuICAgIHZhciBjb2RlTmFtZTogU3RyaW5nIGJ5IENhcGl0YWxpemVEZWxlZ2F0ZSgpXG59XG5cbmNsYXNzIENhcGl0YWxpemVEZWxlZ2F0ZXtcbiAgICB2YXIgdXBwZXJjYXNlZCA9IFwiXCJcbiAgICBvcGVyYXRvciBmdW4gZ2V0VmFsdWUodGhpc1JlZjogQW55PywgcHJvcGVydHk6IEtQcm9wZXJ0eTwqPik6IFN0cmluZyB7XG4gICAgICAgIHByaW50bG4oXCIkdGhpc1JlZiwgdGhhbmsgeW91IGZvciBkZWxlZ2F0aW5nICcke3Byb3BlcnR5Lm5hbWV9JyB0byBtZSFcIilcbiAgICAgICAgcmV0dXJuIHVwcGVyY2FzZWRcbiAgICB9XG5cbiAgICBvcGVyYXRvciBmdW4gc2V0VmFsdWUodGhpc1JlZjogQW55PywgcHJvcGVydHk6IEtQcm9wZXJ0eTwqPiwgdmFsdWU6IFN0cmluZykge1xuICAgICAgICBwcmludGxuKFwiJyR2YWx1ZScgaGFzIGJlZW4gYXNzaWduZWQgdG8gJyR7cHJvcGVydHkubmFtZX0nIGluICR0aGlzUmVmLlwiKVxuICAgICAgICB1cHBlcmNhc2VkID0gdmFsdWUudXBwZXJjYXNlKClcbiAgICB9XG59XG5cbmZ1biBtYWluKCkge1xuICAgdmFsIHN1cGVyTGFuZGVyID0gU3VwZXJIZXJvKClcbiAgIHByaW50bG4oc3VwZXJMYW5kZXIucmFuZG9tU3RyZW5ndGgpXG4gICBwcmludGxuKHN1cGVyTGFuZGVyLnJhbmRvbVN0cmVuZ3RoKVxuICAgXG4gICBzdXBlckxhbmRlci5wb3dlck5hbWUgPSBcInNwZWVkXCJcbiAgICBcbiAgICBzdXBlckxhbmRlci5jb2RlTmFtZSA9IFwic3VwZXJsYW5kZXJcIlxuICAgIHByaW50bG4oc3VwZXJMYW5kZXIuY29kZU5hbWUpXG59In0=) illustrates delegate properties.

## Concurrence et coroutines

Kotlin fournit un modèle de concurrence de haut niveau appelé _Coroutines_.
Le développeur peut déléguer la gestion des threads au compilateur et à l'exécution et utiliser des constructions de niveau supérieur aux threads pour exprimer des opérations asynchrones.

Les coroutines de Kotlin tournent autour de ces concepts :

- Une coroutine est une instance de calcul suspendable.
  - Kotlin a de nombreuses méthodes pour créer une coroutine telle que `launch`.
- Une coroutine doit exister dans une portée de coroutine.
  - Par exemple, `runBlocking` crée une portée de coroutine dans laquelle les coroutines peuvent être lancées.
- Une coroutine peut exécuter des fonctions de suspension qui peuvent suspendre la coroutine mais ne bloquent pas le thread.
  - Par exemple : le `delay` suspend la coroutine mais ne bloque pas le thread sur lequel elle s'exécute.
  - Les fonctions de suspension sont des opérations qui peuvent prendre du temps telles que les requêtes http et les appels au système de fichiers.
- Le qualificateur `suspend` définit une fonction de suspension. Il s'exécute dans une coroutine et peut appeler d'autres fonctions de suspension.
- `Flow` permet de générer une liste de valeurs asynchrones.
- `Deferred` et `Channel` transfèrent respectivement une valeur unique et un flux de valeurs entre coroutines.

[:arrow_forward: this code](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbnguY29yb3V0aW5lcy4qXG5cbnN1c3BlbmQgZnVuIHJ1blNvbWV0aGluZygpIHtcbiAgICBwcmludGxuKFwic3RhcnRpbmdcIilcbiAgICBkZWxheSg1MDApXG4gICAgcHJpbnRsbihcImZpbmlzaGVkXCIpXG59XG5cbi8vIHJ1bkJsb2NraW5nIGNyZWF0ZXMgYSBDb3JvdXRpbmVTY29wZVxuZnVuIG1haW4oKSA9IHJ1bkJsb2NraW5nIHsgXG4gICAgLy8gbGF1bmNoIGEgbmV3IGNvcm91dGluZVxuICAgIGxhdW5jaCB7IFxuICAgICAgICAvLyBTdXNwZW5kIHRoZSBjb3JvdXRpbmUgYnV0IGRvZXMgbm90IGJsb2NrIHRoZSB0aHJlYWRcbiAgICAgICAgZGVsYXkoMTAwMEwpIFxuICAgICAgICBwcmludGxuKFwiV29ybGQhXCIpIFxuICAgIH1cbiAgICAgICAgXG4gICAgLy8gbWFpbiBjb3JvdXRpbmUgY29udGludWVzIHdoaWxlIGEgcHJldmlvdXMgb25lIGlzIGRlbGF5ZWRcbiAgICBwcmludGxuKFwiSGVsbG9cIikgXG4gICAgXG4gICAgdmFsIGpvYiA9IGxhdW5jaCB7XG4gICAgICAgIHJ1blNvbWV0aGluZygpXG4gICAgfVxuICAgIGpvYi5qb2luKClcbiAgICBydW5Tb21ldGhpbmcoKVxuICAgIFxufSJ9) show how to create a coroutine and suspend function and how to use them.

[:arrow_forward: this code](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbnguY29yb3V0aW5lcy4qXG5pbXBvcnQga290bGlueC5jb3JvdXRpbmVzLmZsb3cuKlxuXG5mdW4gZ2VucmF0ZUFzeW5jUmFuZG9tVmFsdWVzKCk6IEZsb3c8SW50PiA9IGZsb3cgeyBcbiAgICBwcmludGxuKFwiRmxvdyBzdGFydGVkXCIpXG4gICAgZm9yIChpIGluIDAuLjEwKSB7XG4gICAgICAgIGRlbGF5KDEwMClcbiAgICAgICAgZW1pdChpKVxuICAgIH1cbn1cblxuLy8gVGhpcyBjYW4gY2F1c2UgcHJvYmxlbXMgaW4gbm90IGhhbmRsZWRlZCBjb3JyZWN0bHlcbmZ1biBnZW5yYXRlQXN5bmNSYW5kb21WYWx1ZXNJbmZpbml0ZSgpOiBGbG93PEludD4gPSBmbG93IHsgXG4gICAgcHJpbnRsbihcIkZsb3cgc3RhcnRlZFwiKVxuICAgIHZhciBpID0gMFxuICAgIHdoaWxlICh0cnVlKSB7XG4gICAgICAgIGRlbGF5KDEwMClcbiAgICAgICAgZW1pdChpKVxuICAgICAgICBpICs9IDFcbiAgICB9XG59XG5cblxuXG4vLyBydW5CbG9ja2luZyBjcmVhdGVzIGEgQ29yb3V0aW5lU2NvcGVcbmZ1biBtYWluKCkgPSBydW5CbG9ja2luZzxVbml0PiB7XG4gICAgbGF1bmNoe1xuICAgICAgICBnZW5yYXRlQXN5bmNSYW5kb21WYWx1ZXMoKS5jb2xsZWN0IHtcbiAgICAgICBcdFx0cHJpbnRsbihcIjFzdCBmbG93OiBHb3QgJGl0XCIpXG4gICBcdFx0fVxuICAgIH1cbiAgIFxuICAgbGF1bmNoe1xuICAgICAgIHdpdGhUaW1lb3V0T3JOdWxsKDEwMDApe1xuICAgICAgICAgICBnZW5yYXRlQXN5bmNSYW5kb21WYWx1ZXMoKS5jb2xsZWN0IHtcbiAgICAgICAgICAgcHJpbnRsbihcIjJuZCBmbG93OiBHb3QgJGl0XCIpXG4gICAgICAgICB9XG4gICAgICAgfVxuICAgfVxufSJ9) illustrated flows.

[:arrow_forward: this code](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbnguY29yb3V0aW5lcy4qXG5pbXBvcnQga290bGlueC5jb3JvdXRpbmVzLmNoYW5uZWxzLipcblxuZnVuIG1haW4oKSA9IHJ1bkJsb2NraW5nIHtcbiAgICBcbiAgICAvLyBhc3luYyBsYXVuY2hlcyBhIGNvcm91dGluZXMgYW5kIHJldHVybnMgYSBEZWZlcnJlZDxJbnQ+XG4gICAgdmFsIGRlZmVycmVkID0gYXN5bmMge1xuICAgICAgICA0MlxuICAgIH1cbiAgICBwcmludGxuKGRlZmVycmVkLmF3YWl0KCkpXG5cbiAgICB2YWwgY2hhbm5lbCA9IENoYW5uZWw8SW50PigpXG4gICAgbGF1bmNoIHtcbiAgICAgICAgLy8gdGhpcyBtaWdodCBiZSBoZWF2eSBDUFUtY29uc3VtaW5nIGNvbXB1dGF0aW9uIG9yIGFzeW5jIGxvZ2ljLCB3ZSdsbCBqdXN0IHNlbmQgZml2ZSBzcXVhcmVzXG4gICAgICAgIGZvciAoeCBpbiAxLi41KSBjaGFubmVsLnNlbmQoeCAqIHgpXG4gICAgfVxuICAgIC8vIGhlcmUgd2UgcHJpbnQgZml2ZSByZWNlaXZlZCBpbnRlZ2VyczpcbiAgICByZXBlYXQoNSkgeyBwcmludGxuKGNoYW5uZWwucmVjZWl2ZSgpKSB9XG4gICAgcHJpbnRsbihcIkRvbmUhXCIpXG5cbn0ifQ==) illustrates channels and deferred.

## Littéral de fonction avec récepteur et constructeurs de type sécurisé

Comme vu précédemment, les extensions de fonctions ajoute du comportement à des classes existantes sans utiliser l'héritage.
À l'intérieur de la définition de l'extension de fonction, nous pouvons référencer implicitement le **récepteur d'extension** (`this`).

```kotlin
fun String.countCharacters() = length // or this.length
println("hello".countCharacters()) // prints 5
```

Nous pouvons définir cette extension avec une fonction littérale (ou lambda) au lieu d'une fonction classique (déclarée avec `fun`).

```kotlin
var extFn: String.() -> Int
extFn = { length } // extFn is a function literal
println("hello".extFn()) // prints 5
println(extFn("hello")) // prints 5
```

`extFn` **est une fonction littérale** (lambda) qui a accès au **récepteur** (`this`).
C'est pourquoi on l'appelle une **fonction littérale avec récepteur**.

`extFn("hello")` ou `extFn("hello")` appelle l'extension comme prévu par les fonctions d'extension.

Le type d'une fonction littérale avec récepteur est `funName: ReceiverType.(arg1Type, arg2Type, etc.) -> ReturnType` et est appelé avec `funName(receiverValue, arg1Value, etc.)` ou `receiverValue.funName(arg1Value, etc.) .)`. Cependant, ce n'est pas l'aspect le plus intéressant.

La partie importante est `extFn = { length }` qui peut être placée comme argument de fonction dans une fonction d'ordre supérieur.
Le développeur qui appelle la fonction d'ordre supérieur doit définir `extFn`, qui à son tour a accès au récepteur.
Cela permet un style de programmation assez intéressant.

[:arrow_forward: ce code](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbi5yYW5kb20uUmFuZG9tXG5cbmZ1biBtYWluKCkge1xuICAgIC8vIGZuIGlzIGEgZnVuY3Rpb24gbGl0ZXJhbHMgd2l0aCByZWNlaXZlciB0aGF0IHJldHVybnMgYW4gaW50XG4gICAgZnVuIGRvU29tZXRoaW5nV2l0aFJhbmRvbUludChmbjogSW50LigpIC0+IEludCk6IEludCB7XG4gICAgXHR2YWwgcmFuZG9tSW50ID0gUmFuZG9tLm5leHRJbnQoMzIsIDk4KVxuICAgIFx0cmV0dXJuIHJhbmRvbUludC5mbigpXG5cdH1cbiAgICAgXG4gICAgdmFsIHJlc3VsdCA9IGRvU29tZXRoaW5nV2l0aFJhbmRvbUludCB7XG4gICAgICAgIC8vIFRoZSByZWNlaXZlciBpcyBpbXBsaWNpdGx5IGF2YWlsYWJsZSBpbiB0aGlzIGxhbWJkYVxuICAgICAgICBwcmludGxuKFwidGhpczogJHRoaXNcIilcbiAgICAgICAgcHJpbnRsbihcInBsdXM6ICR7cGx1cygxMDApfVwiKVxuICAgICAgICBtaW51cyg1MDApXG4gICAgfVxuICAgIHByaW50bG4oXCJyZXN1bHQgOiAkcmVzdWx0XCIpXG59In0=) montre un example.

[**Les Type-safe builders**](https://kotlinlang.org/docs/type-safe-builders.htmlhttps://kotlinlang.org/docs/type-safe-builders.html) combinent les monteurs bien nommées et les fonctions littérales avec récepteur pour créer des monteur avec un typage statique et sécurisé.
La syntaxe particulière possible avec technique permet de définir une sorte de sous-langage aussi appelé DSL (domain specific language).

::: tip Le pattern monteur (Builder)
Est une technique permettant [de construire des objects avec une syntaxe élégante](https://refactoring.guru/design-patterns/builder).

```kotlin
// StirngBuilder uses the builder pattern
val text = StringBuilder("Temp")
  .append(1)
  .append(true)
  .append("friend")
  .toString()
```

:::

[Ce code montre](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiY2xhc3MgTWlsa3tcbiAgICB2YXIgYnJhbmQ6IFN0cmluZyA9IFwiXCJcbiAgICB2YXIgcXVhbnRpdHk6IEludCA9IDBcbiAgICBmdW4gYnJhbmQoaGFuZGxlcjogTWlsay4oKS0+IFN0cmluZyl7XG4gICAgICAgIGJyYW5kID0gaGFuZGxlcigpXG4gICAgfVxuICAgIGZ1biBxdWFudGl0eShoYW5kbGVyOiBNaWxrLigpLT5JbnQpe1xuICAgICAgICBxdWFudGl0eSA9IGhhbmRsZXIoKVxuICAgIH1cbiAgICBvdmVycmlkZSBmdW4gdG9TdHJpbmcoKSA9IFwiJHF1YW50aXR5IEwgb2YgbWlsayBmcm9tICRicmFuZFwiXG59XG5cbi8vIHR5cGVzYWZlIGJ1aWxkZXIgZW50cnkgcG9pbnRcbmZ1biBwcm9kdWNlTWlsayhpbml0OiBNaWxrLigpIC0+IFVuaXQpOiBNaWxrIHtcbiAgICB2YWwgbWlsayA9IE1pbGsoKVxuICAgIG1pbGsuaW5pdCgpXG4gICAgcmV0dXJuIG1pbGtcbn1cblxuZnVuIG1haW4oKXtcbiAgICB2YWwgbWlsayA9IHByb2R1Y2VNaWxrIHtcbiAgICAgICAgYnJhbmQgeyBcIlN1cGVyIG1pbGtcIiB9XG4gICAgICAgIHF1YW50aXR5IHsgMTAwIH1cbiAgICB9XG4gICAgcHJpbnRsbihtaWxrKVxufSJ9) un type-safe builder basique.

[Kotlin docs](https://kotlinlang.org/docs/type-safe-builders.html) fournit un exemple plus avancé d'un monteur de documents HTML.

## Exercises

### Exercise 1

1. open the **java-integration-exercise** projects in the **materials** folder.
1. Have a look at the Java class we provided you in the `src/main/java/com/worldline/learning/kotlin/java2kotlin` package. _(yes, that's the Pokemon class)_
1. Convert that Java class in Kotlin using IntelliJ's awesome copy-pasta tool! _(just copy paste the java code in a kotlin file, one is provided at `src/main/kotlin/com/worldline/learning/kotlin/java2kotlin`)_
1. Have a look at the generated Kotlin code, and note the major differences you spot!
