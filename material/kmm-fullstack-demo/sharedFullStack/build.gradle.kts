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
