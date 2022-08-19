# Kotlin

Kotlin is an object oriented langiage with functional features.


## Basic constructs (varabiles, control flow)

- Kotlin is statically typed and supports implicit typing.
  - *Static* typing: types cannot change on runtime (it is the opposite of dynamic typing).
  - *Implicit* typing: the compiler can infer the type whenever possible.
- `val` creates immutable variables or constants
- `var` creates mutable variables
- Use val as much as possible
- _In kotlin, semi-colons are optionnal_
- Kotlin supports top level declaration of variables and functions (They can be declared outside of classes)
- String interpolation is available with this syntax `${expression}`.
- `if`, and `when` statements are expressions (they can return a value).
  - `when` is equivalent to the `switch` statement of other languages
  - The ternary operator is not available and `ìf` statements replace-it.
- for-each is the only type of for loop available.
- Object oriented programming is supported as in Java with some additional features.
- The compiler supports *Null Safety*. It allows to write code free from null pointer errors at compile time.
- Functional programming is supported (Higher-order functions and functions as 1st class items, etc.).

This code highlights some basic features:

<iframe src="https://pl.kotl.in/V2XldkbDd"></iframe>

## Functions

<iframe src="https://pl.kotl.in/UKA_Zstd9"></iframe>

## Null safety

## Object oriented features (classes, interfaces, etc.)

### Sealed classes
### Data class
### Companion object

## Functionnal feautres (for example: collection manipulation)

## Extensions