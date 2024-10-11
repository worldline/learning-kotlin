plugins {
    alias(libs.plugins.jvm)
    application
}

repositories {
    mavenCentral()
}
dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation(libs.junit.jupiter.engine)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(libs.guava)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    mainClass.set("kotlin2.experimental.AppKt")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

kotlin {
    sourceSets.all {
        // Must be explcitly enabled!
        languageSettings.enableLanguageFeature("ExplicitBackingFields")
    }
}
