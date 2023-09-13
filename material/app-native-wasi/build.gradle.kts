import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform") version "1.9.20-Beta"
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
}
