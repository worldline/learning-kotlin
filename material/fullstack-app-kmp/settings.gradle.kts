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
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "km"
include(":composeWebCanvasApp", ":androidApp", ":shared", ":sharedFullStack", ":iosApp", ":desktopApp")
