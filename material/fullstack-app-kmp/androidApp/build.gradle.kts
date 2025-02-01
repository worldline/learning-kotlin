plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.devoxxfr2023.km.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.devoxxfr2023.km.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1,io.netty.versions.properties,INDEX.LIST}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.7.7")
    implementation("androidx.compose.ui:ui-tooling:1.7.7")
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.7")
    implementation("androidx.compose.foundation:foundation:1.7.7")
    implementation("androidx.compose.material:material:1.7.7")
    implementation("androidx.activity:activity-compose:1.10.0")
}