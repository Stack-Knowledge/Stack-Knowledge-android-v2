@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("stackknowledge.android.feature")
    id("stackknowledge.android.hilt")
}

android {
    namespace = "com.stackknowledge.login"
}