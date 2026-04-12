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

rootProject.name = "InvoiceGenerator"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":shared")
include(":androidApp")
