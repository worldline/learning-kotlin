plugins {
    kotlin("multiplatform") version "1.9.20-Beta"
}

group = "tech.worldline.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    js {
        nodejs {
        }
        binaries.executable()
        useCommonJs()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(npm("express", "> 4.0.0 < 5.0.0"))
                implementation(npm("body-parser", "> 1.0.0 < 2.0.0"))
                implementation("dev.chriskrueger:kotlin-express:1.2.0")
            }
        }
    }
}