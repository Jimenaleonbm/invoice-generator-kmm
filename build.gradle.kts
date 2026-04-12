plugins {
    // Kotlin Multiplatform
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    // Android
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    // SQLDelight
    alias(libs.plugins.sqlDelight).apply(false)
    // Jetpack Compose
    alias(libs.plugins.jetbrainsCompose).apply(false)
    alias(libs.plugins.composeCompiler).apply(false)
}
