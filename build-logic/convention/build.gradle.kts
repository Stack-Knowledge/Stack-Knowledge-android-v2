import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "stackknowledge.android.application"
            implementationClass = "com.convention.AndroidApplicationConventionPlugin"
        }

        register("androidHilt") {
            id = "stackknowledge.android.hilt"
            implementationClass = "com.convention.AndroidHiltConventionPlugin"
        }

        register("androidLint") {
            id = "stackknowledge.android.lint"
            implementationClass = "com.convention.AndroidLintConventionPlugin"
        }

        register("androidCore") {
            id = "stackknowledge.android.core"
            implementationClass = "com.convention.AndroidCoreConventionPlugin"
        }

        register("androidCompose") {
            id = "stackknowledge.android.compose"
            implementationClass = "com.convention.AndroidComposeConventionPlugin"
        }

        register("jvmLibrary") {
            id = "stackknowledge.jvm.library"
            implementationClass = "com.convention.JvmLibraryConventionPlugin"
        }

        register("androidFeature") {
            id = "stackknowledge.android.feature"
            implementationClass = "com.convention.AndroidFeatureConventionPlugin"
        }
    }
}