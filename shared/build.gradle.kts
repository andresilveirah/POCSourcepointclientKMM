plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization") version "1.8.22"
    id("com.android.library")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "A proof of concept client for sourcepoint APIs using Kotlin Multiplatform"
        homepage = "https://github.com/andresilveirah/POCSourcepointclientKMM"
        source = "{ 'http' => 'https://github.com/andresilveirah/POCSourcepointclientKMM' }"
        authors = "{ 'Andre Herculano' => 'andresilveirah@gmail.com' }"
        version = "0.0.1"
        ios.deploymentTarget = "11.0"
        podfile = project.file("../iosApp/Podfile")
        name = "POCSourcepointClient"
        framework {
            baseName = "POCSourcepointClient"
            transitiveExport = true
        }
    }
    
    sourceSets {
        val ktorVersion = "2.3.2"
        val coroutinesVersion = "1.7.2"
        val commonMain by getting {
            dependencies {
                implementation("com.russhwolf:multiplatform-settings:1.0.0")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:$ktorVersion")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
            }
        }
    }
}

android {
    namespace = "com.sourcepoint.sourcepointkmm"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
    }
}