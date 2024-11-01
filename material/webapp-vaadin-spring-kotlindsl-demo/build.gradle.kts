import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.3.5"
    id("io.spring.dependency-management") version "1.1.6"
    id("com.vaadin") version "24.5.2"
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.spring") version "2.0.21"
}

group = "com.worldline"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

extra["vaadinVersion"] = "24.3.9"

dependencies {
    implementation("com.vaadin:vaadin-spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.github.mvysny.karibudsl:karibu-dsl:2.1.4")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("com.vaadin:vaadin-bom:${property("vaadinVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
