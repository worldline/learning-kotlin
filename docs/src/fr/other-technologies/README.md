# Kotlin native and KMP / KMM

This section explores other technologies that Kotlin supports.

## Kotlin native

Kotlin native allows to create apps or libraries that compile to native binaries.
This makes Kotlin similar to languages such as C or C++ with additional features:

- Supported platforms: Apple (macOS, iOS, tvOS, watchOS), Linux, Windows (MinGW), JS and Android NDK. The full [list is available here](https://kotlinlang.org/docs/multiplatform-dsl-reference.html#targets)
- Two-way interoperability with the target platform's programming languagues. 
  - The compiler creates a binary compatible with the target. For example, Kotlin native generates an Apple framework for Swift and Objective-C projects.
  - Kotlin native can use native libraries. For example, it can use C, Swift, and Objective-C frameworks on Apple platfrorms.
- Kotlin standard library is available.
- Possiblity to share a single codebase across multiple platforms. Kotlin multiplaform helps making corss-platform apps with Kotlin straightforward.

## Kotlin multiplatform (KMP)

[Kotlin multiplatform](https://blog.jetbrains.com/kotlin/2021/08/compose-multiplatform-goes-alpha/) relies on Kotlin native and Kotlin features to help developers create projects that target multiple platforms using a common code-base in coded Kotlin. 

![KMP](https://kotlinlang.org/docs/images/kotlin-multiplatform.png)

Many combinations of targets and use cases are possible:

- [Full-Stack web apps](https://kotlinlang.org/docs/multiplatform-full-stack-app.html): A project that contains a backend and a web app while sharing common logic.
- [Multiplatform libraries](https://kotlinlang.org/docs/multiplatform-library.html)
- [Kotlin Multiplatform Mobile (KMM)](https://kotlinlang.org/lp/mobile/): a special denomination for KMP when used for iOS and Android projects.
  - It allows to share a single codebase for the logic. 
  - :warning: KMM does not share view logic.
  - :bulb: To develop the views: we must use native SDKs or any SDK compatible with KMM. For example, KMP + KMM + Compose allows to develop the logic + the UI all in a single Kotlin project.


![KMM](https://kotlinlang.org/lp/mobile/static/sdk-313e52f7d9d3b3e3e48471ef06e8e3aa.svg)

## PW: create a KMP full-Stack web app

Please follow this [Kotlin Hands-On tutorial](https://play.kotlinlang.org/hands-on/Full%20Stack%20Web%20App%20with%20Kotlin%20Multiplatform/01_Introduction)