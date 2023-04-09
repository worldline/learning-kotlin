plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.4.2").apply(false)
    id("com.android.library").version("7.4.2").apply(false)
    kotlin("android").version("1.8.0").apply(false)
    kotlin("multiplatform").version("1.8.0").apply(false)
    id("org.jetbrains.compose").version("1.3.1").apply(false)
    id("org.jetbrains.kotlin.jvm") version "1.8.0" apply false

}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
