plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.4.2").apply(false)
    id("com.android.library").version("7.4.2").apply(false)
    // which version of Kotlin and compose to use https://github.com/JetBrains/compose-multiplatform/blob/master/VERSIONING.md#kotlin-compatibility
    kotlin("android").version("1.8.10").apply(false)
    kotlin("multiplatform").version("1.8.10").apply(false)
    id("org.jetbrains.compose").version("1.3.1").apply(false)
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
    kotlin("plugin.serialization") version "1.8.10" apply false

}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
