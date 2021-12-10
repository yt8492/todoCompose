import org.jetbrains.compose.compose
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("kotlin-parcelize")
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm()
    android()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api("com.arkivanov.decompose:decompose:0.2.6")
                api("com.arkivanov.decompose:extensions-compose-jetbrains:0.2.6")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
            }
        }
    }
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

android {
    compileSdkVersion(30)

    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res")
        }
    }
}
