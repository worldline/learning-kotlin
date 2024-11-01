import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform") version "2.1.0-Beta2"
}

group = "tech.worldline.demo"

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    wasmWasi {
        nodejs()
    }

    fun configureNative(target: KotlinNativeTarget){
        target.binaries {
            executable()
        }
    }
    mingwX64 {
        configureNative(this)
    }
    linuxX64 {
        configureNative(this)
    }
    macosX64 {
        configureNative(this)
    }
    linuxArm64 {
        configureNative(this)
    }
}
