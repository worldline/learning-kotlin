import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.devoxxfr2023.km"
version = "1.0-SNAPSHOT"

kotlin {
    jvm {
        jvmToolchain(11)
        withJava()

    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(project(":shared"))
                implementation(compose.desktop.currentOs)
            }

        }
    }

}

compose.desktop { // the block replace
    application { // application previous declaration for gradle task "run"
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi, TargetFormat.Deb)
            packageName = "desktop"
            packageVersion = "1.0.0"
        }
    }
}


