import org.gradle.kotlin.dsl.commonMain
import org.gradle.kotlin.dsl.commonMainImplementation
import org.gradle.kotlin.dsl.kspCommonMainMetadata
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinAndroidTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kmmbridge)
    alias(libs.plugins.skie)
    alias(libs.plugins.ksp)
    `maven-publish`
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
        publishAllLibraryVariants()
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            isStatic = true
        }
    }

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlin.inject.runtime)
        }
    }
}

dependencies {
    kspCommonMainMetadata(libs.kotlin.inject.compiler.ksp)

    add("kspAndroid", libs.kotlin.inject.compiler.ksp)
    add("kspIosX64", libs.kotlin.inject.compiler.ksp)
    add("kspIosArm64", libs.kotlin.inject.compiler.ksp)
    add("kspIosSimulatorArm64", libs.kotlin.inject.compiler.ksp)

//    kspCommonMainMetadata(libs.anvil.compiler)
    add("kspAndroid", libs.anvil.compiler)
    add("kspIosX64", libs.anvil.compiler)
    add("kspIosArm64", libs.anvil.compiler)
    add("kspIosSimulatorArm64", libs.anvil.compiler)

    commonMainImplementation(libs.anvil.runtime)
    commonMainImplementation(libs.anvil.runtime.optional)
    commonMainImplementation(libs.kotlinx.coroutines.core)
}

addGithubPackagesRepository()

kmmbridge {
    gitHubReleaseArtifacts()
    spm()
}

skie {
    build {
        produceDistributableFramework()
    }
}

android {
    namespace = "uk.co.atomicmedia.eskklk"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}