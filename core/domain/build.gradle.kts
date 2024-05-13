@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("stackknowledge.android.core")
    id("stackknowledge.android.hilt")
}

android {
    namespace = "com.stackknowledge.domain"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    implementation(libs.kotlinx.datetime)
}