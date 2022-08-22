# Kotlin

Kotlin is an object oriented langiage with functional features.


## Basic constructs (varabiles, control flow)

- Kotlin is statically typed and supports implicit typing.
  - *Static* typing: types cannot change on runtime (it is the opposite of dynamic typing).
  - *Implicit* typing: the compiler can infer the type whenever possible.
- `val` creates immutable variables or constants
- `var` creates mutable variables
- Use val as much as possible
- In Kotlin, semi-colons are optional
- Kotlin supports top level declaration of variables and functions (They can be declared outside of classes)
- String interpolation is available with this syntax `${expression}`.
- `if`, and `when` statements are expressions (they can return a value).
  - `when` is equivalent to the `switch` statement of other languages
  - The ternary operator is not available and `ìf` statements replace-it.
- for-each is the only type of for loop available.
- Object oriented programming is supported as in Java with some additional features.
- The compiler supports *Null Safety*. It allows to write code free from null pointer errors at compile time.
- Functional programming is supported (Higher-order functions and functions as 1st class items, etc.).

[This code](https://pl.kotl.in/gWr1eZiDL) highlights the above features.

## Functions

In the this section, the terms 'argument' and 'parameter' are used interchangeably.

Functions in Kotlin have the following features:

- Declaration: `fun functionName(arg1: type1 = defaultvalue1, ...) : retunrType`.
- Call a function by passing the value in the declaration order. Use the argument name for more clarity.
  - Naming arguments during the call allow for arbitrary ordering of arguments.
- Arguments can have a default value and are called optional arguments.
- Functions are first class items or citizen: they can be assigned to a variable, passed as a function parameter, or returned from a function.
- A function type can be expressed as follows: `(typeOfParam1, typeOfParam2, etc) -> returnType` (The empty return type is `Void`).
- Anonymous functions (also called lambda function) use the following syntax `{ argName1, argName2, etc. -> // code }`
- The last argument can be put after the closing after the closing parenthesis `compute(9, 5) { x, y -> x * y }`

[This code](https://pl.kotl.in/1g4O5El82) highlights the above features.

The next section talk about *null safety*.

## Null safety


In a nutshell, *null safety* is a compiler feature that allows you to avoid the infamous *Null pointer exception* or *npe*.
The Kotlin compiler reports errors and warnings when we manipulate nullable (also called optional) values. Here is a list of null safety features provided by Kotlin:

- All types are non optional by default. This means that we cannot assign `nulll` to a variable or an argument. For example, this code fails `var s: String = nil`.
- A type can be made optional by suffixing it with a *?*. For example: `var s: String? = nil`.
- You cannot call a method or a property of an optional type, unless you do one of those possibilities:
  - Use optional chaining with the *?* suffix.
  - Provide a default value with the *??* operator.
  - Unwrap the optional so that it becomes non optional.
  - Force unwrap the optional using the *!* suffix. This should never be used as it bypasses compiler checks.

::: danger Never unwrap with !
You must never force unwrap with the *!*. 
Use other unwrapping techniques instead.
On of the rarest exceptions is with Interface builder's Outlets in UIKit `@IBOutlet var label: UILabel!`.
Fortunately, since we are not using UIKit in this training, we will avoid this situation.
:::

[This code](https://pl.kotl.in/LnYukBMSD) illustrates null safety and how to use optional types.

::: warning Java `Optional` does not provide compile time null checks
It is a runtime wrapper around null values and the compiler does not provide unwrapping features such as smart casting.
It is still possible to have a npe like this: `Optional<String> s = null; s.isPresent()`;
:::

## Enumerations

Enumerations allow to work with a group of values in a type-safe fashion.
Unlike Java enums, [Kotlin enums are classes](https://www.geeksforgeeks.org/enum-classes-in-kotlin).
Kotlin enum classes provide these features:

- `when` statements support enumerations.
- Enum constants can declare their own anonymous classes with their corresponding methods, as well as with overriding base methods.
- An enum class can implement an interface but it cannot derive from a class
- There are methods for listing the defined enum constants and getting an enum constant by its name.
- Every enum constant has properties for obtaining its name and position (starting with 0).

[This code](https://pl.kotl.in/5u9rNmg7q) illustrated the features above. For further reading please consult [the official documentation](https://kotlinlang.org/docs/enum-classes.html#working-with-enum-constants).

## Exercises (part 1)

### Exercise 1

[Please click on this link to view the exercise](https://pl.kotl.in/HR6E0vnHv)

::: details Please open to see the solution(s)
[Solution](https://pl.kotl.in/HKYZtSSHN)
:::

### Exercise 2

[Please click on this link to view the exercise](https://pl.kotl.in/ovfJtauq8)

::: details Please open to see the solution(s)
[Solution](https://pl.kotl.in/9jYXfebh3)
:::

## Object oriented programming



### Sealed classes
### Data class
### Companion object

## Functional programming

Functional programming revolves around [these concepts](https://www.geeksforgeeks.org/functional-programming-paradigm): pure functions, recursion, Referential transparency, Immutable variables, and Functions are First-Class and can be Higher-Order.

Let's briefly explain these concepts:

- Immutable variables means that we cannot change the value of a variable or its properties once it has been created. If we want to do so, we must create a new instance with the new value.
- Pure functions are functions that do not have side effects and will thus return always the same output given the same input.
- Functions are first class items: they can be assigned to a variable, passed as a function parameter to another function (higher order function), or returned from a function.
- [Referential transparency](https://ericnormand.me/podcast/what-is-referential-transparency): means that an expression can be replaced by its result without changing the behavior of the program. Transparency refers to the fact that the implementation of the expression is irrelevant.

Pure functional languages provide these features natively (or at compile) and enforces them.
Kotlin does not enforce them but helps developers that want to follow them.

Declarative programming is a famous style within functional programming.
It consists of writing code as a chaining of function calls in this manner `val result = f(x).g(y). ...`.
Even loops are replaced by higher order functions.
These functions follow functional programming concepts covered above.
This favors readable code which is easy to debug an maintain.



## Extensions

## Exercises (part 2)

## More Exercises and reading

- [Kotlin Koans](https://play.kotlinlang.org/koans/overview)
- [Referential transparency](https://sderosiaux.medium.com/why-referential-transparency-matters-7c179424dab5)