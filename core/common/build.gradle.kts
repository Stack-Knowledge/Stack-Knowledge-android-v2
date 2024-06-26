@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("stackknowledge.android.core")
    id("stackknowledge.android.hilt")
}

android {
    namespace = "com.stackknowledge.common"
}

dependencies {
    testImplementation(libs.kotlinx.coroutines.test)
}