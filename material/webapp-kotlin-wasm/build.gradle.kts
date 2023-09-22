plugins { kotlin("multiplatform") version "1.9.20-Beta" }

group = "tech.worldline.demo"

version = "1.0-SNAPSHOT"

repositories { mavenCentral() }

kotlin {
    wasmJs {
        binaries.executable()
        browser {}
    }
}
