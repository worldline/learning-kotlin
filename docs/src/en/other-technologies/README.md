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

```kts
plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

group = "tech.worldline.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        jvmToolchain(11)
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(BOTH) {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }


    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("io.ktor:ktor-client-content-negotiation:2.2.1")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.2.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
```

- Run the app to check that everything still works
- Next, we'll add a new module Ktor server App module
-
