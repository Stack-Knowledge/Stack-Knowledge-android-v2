@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("stackknowledge.android.core")
    id("stackknowledge.android.compose")
    id("stackknowledge.android.lint")
}

android {
    namespace = "com.stackknowledge.design_system"
}

dependencies {
    implementation(libs.coil.kt.compose)
}