@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("stackknowledge.android.core")
    id("stackknowledge.android.hilt")
}

android {
    namespace = "com.stackknowledge.data"
}

dependencies {
    implementation(project(":core:datastore"))
    implementation(project(":core:model"))
    implementation(project(":core:network"))

    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}