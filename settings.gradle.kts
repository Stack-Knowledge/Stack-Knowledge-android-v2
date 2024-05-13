pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "StackKnowledge"
include(":app")

include(":core:data")
include(":core:datastore")
include(":core:design-system")
include(":core:domain")
include(":core:model")
include(":core:network")

include(":feature:main")
include(":core:ui")
include(":feature:mission")
include(":feature:login")
include(":feature:resolve-mission")
include(":feature:ranking")
include(":feature:shop")
include(":feature:score-mission")
