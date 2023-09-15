import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "tech.worldline.km"
version = "1.0-SNAPSHOT"

kotlin {
    js {
        binaries.executable()
        browser {

        }
    }

    sourceSets {
//        val jsMain by getting {
//            dependencies {
//                implementation(project(":shared"))
//                implementation(compose.web.core)
//                implementation(compose.ui)
//                @OptIn(ExperimentalComposeLibrary::class)
//                implementation(compose.material3)
//            }
//        }
    }
}

compose.experimental {
    web.application {}
}