import org.jetbrains.compose.ExperimentalComposeLibrary

val ktorVersion: String by project

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    js(IR) {
        browser()
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    jvm("desktop") {
        jvmToolchain(11)
    }
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":sharedFullStack"))
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)
                implementation("io.ktor:ktor-client-core:$ktorVersion") // core source of ktor
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0") // For making asynchronous calls
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion") // Simplify handling of content type based deserialization
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                api("moe.tlaster:precompose:1.6.2")

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:$ktorVersion") // for Android
            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion") //for iOS
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
                implementation("io.ktor:ktor-client-apache:$ktorVersion")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.ui)
                @OptIn(ExperimentalComposeLibrary::class)
                implementation(compose.material3)
            }
        }
    }
}

android {
    namespace = "com.devoxxfr2023.km"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }

}

dependencies {
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.5")
    debugImplementation("androidx.compose.ui:ui-tooling:1.7.5")
}
