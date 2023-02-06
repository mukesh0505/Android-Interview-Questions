plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = AppConfig.applicationId
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Libs.coreKtx)
    implementation(Libs.lifeCycleRuntimeKtx)
    implementation(Libs.activityCompose)
    implementation(Libs.composeUi)
    implementation(Libs.composeUiToolPreview)
    implementation(Libs.composeMaterial)
    testImplementation(Libs.jUnit)
    androidTestImplementation(Libs.androidTestExtJunit)
    androidTestImplementation(Libs.espresso)
    androidTestImplementation(Libs.composeUiJunitTest)
    debugImplementation(Libs.composeUiTooling)
    debugImplementation(Libs.composeUiManifest)
}