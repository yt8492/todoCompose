group = "com.yt8492"
version = "1.0"

buildscript {
    val kotlin_version by extra("1.5.10")
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0-beta05")
        classpath("org.jetbrains.compose:compose-gradle-plugin:0.5.0-build235")
        classpath(kotlin("gradle-plugin", version = "1.5.10"))
    }
}

allprojects {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}