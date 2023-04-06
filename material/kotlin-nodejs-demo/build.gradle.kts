plugins {
    kotlin("js") version "1.8.20"
}

group = "tech.worldline.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(npm("express", "> 4.0.0 < 5.0.0"))
    implementation("dev.chriskrueger:kotlin-express:1.2.0")
}

kotlin {
    js {
        binaries.executable()
        nodejs {

        }
        useCommonJs()
    }
}