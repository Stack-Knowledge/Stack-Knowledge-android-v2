@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("stackknowledge.android.core")
    id("stackknowledge.android.hilt")
    alias(libs.plugins.protobuf)
}

android {
    namespace = "com.stackknowledge.datastore"
}

protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                register("java") {
                    option("lite")
                }
                register("kotlin") {
                    option("lite")
                }
            }
        }
    }
}

dependencies {
    implementation(project(":core:model"))

    implementation(libs.androidx.dataStore.core)
    implementation(libs.protobuf.kotlin.lite)
}