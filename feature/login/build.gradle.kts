import java.io.FileInputStream
import java.util.Properties

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("stackknowledge.android.feature")
    id("stackknowledge.android.hilt")
}

android {
    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        buildConfigField("String", "REDIRECT_URI", getApiKey("REDIRECT_URI"))
        buildConfigField("String", "GOOGLE_CLIENT_ID", getApiKey("GOOGLE_CLIENT_ID"))
        buildConfigField("String","SCOPE", getApiKey("SCOPE"))
    }
    namespace = "com.stackknowledge.login"
}

dependencies {
    implementation(libs.google.services)
//    implementation(libs.firebase.auth)
//    implementation(libs.firebase.bom)
    implementation(libs.play.services.auth)
}
fun getApiKey(propertyKey: String): String {
    val propFile = rootProject.file("./local.properties")
    val properties = Properties()
    properties.load(FileInputStream(propFile))
    return properties.getProperty(propertyKey)
}