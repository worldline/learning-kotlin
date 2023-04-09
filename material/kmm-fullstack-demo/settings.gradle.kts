pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "km"
include(":androidApp", ":shared", ":sharedFullStack", ":iosApp", ":desktopApp")
