plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        val commonMain by getting{
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4") // For making asynchronous calls
                implementation("io.ktor:ktor-client-content-negotiation:2.2.1") // Simplify handling of content type based deserialization
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