@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("stackknowledge.android.core")
    id("stackknowledge.android.hilt")
}

android {
    namespace = "com.stackknowledge.datastore"
}

dependencies {
    implementation(project(":core:model"))

    implementation(libs.androidx.dataStore.core)
    implementation(libs.androidx.dataStore.preferences)
}