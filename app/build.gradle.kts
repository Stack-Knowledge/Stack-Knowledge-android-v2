@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("stackknowledge.android.application")
    id("stackknowledge.android.hilt")
}

android {
    namespace = "com.stackknowledge.user"

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/DEPENDENCIES"
        }
    }
}

dependencies {
    implementation(project(":core:design-system"))
    implementation(project(":feature:login"))
    implementation(project(":feature:main"))
    implementation(project(":feature:mission"))
    implementation(project(":feature:resolve-mission"))
    implementation(project(":feature:ranking"))
    implementation(project(":feature:score-mission"))
    implementation(project(":feature:shop"))
}