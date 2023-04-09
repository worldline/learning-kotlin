# Cross-plaform app Codelab

## PW : Cross-platform app + KMM + KMP for Android, iOS and Desktop

By combining KMP, KMM and Compose, it is possible to fully develop cross-platform mobile and desktop apps using only Kotlin.

This pw is so huge [that it has its own codelab](https://worldline.github.io/learning-kotlin-multiplatform/)

## PW : Add a Ktor server App

- Add a module into the project called **sharedFullStack** which will serve as a KMP shared library, thus, it will have the `kotlin("multiplatform")` plugin
- For completeness, it will targets all possible platforms native, desktop, iOS, Android, JS, etc.
- Since we are targeting JS, we'll add this line into **setting.gradle.kts**: `kotlin.js.compiler=ir` in order to use the new Kotlin/JS compiler.
- Our clean task may conflict with Kotlin/JS's one, if that the case, we can fix this by renaming our clean task in the root **build.gradle.kts**
- We will only need the common sourceSets (main and test) because it will only contain the API model classes (`Anwser`, `Quiz` and `Question`), thus this module should have the `kotlin("plugin.serialization")` plugin
- In terms of dependencies, this module will include the dependencies used across all projects so that we don't need to repeat them everywhere and thus can also removed from the . For example, `org.jetbrains.kotlinx:kotlinx-coroutines-core:` can be removed from **shared** and placed into **sharedFullStack**
- The build.gradle.kts of the **sharedFullStack** module should look as follows.
- In android build file add io.netty.versions.properties and INDEX.LIST to packagingOptions excldues
- In CommonMain -> QuizAPI.txt, change the url to [http://localhost:8080/quiz](http://localhost:8080/quiz) and remove the arguments of the json method above.
