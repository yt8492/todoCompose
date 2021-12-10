pluginManagement {
    repositories {
        gradlePluginPortal()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }
}
rootProject.name = "todoCompose"
include("common")
include("common-ui")
include("desktop")
include("android")
include("web")
