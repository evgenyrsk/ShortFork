plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(project(":core"))
    implementation(project(":feature-aggregator"))

    implementation(Dependencies.Kotlin.kotlin_std)

    implementation(Dependencies.CoreLibs.appCompat)
    implementation(Dependencies.CoreLibs.core)
    implementation(Dependencies.CoreLibs.material)
    implementation(Dependencies.CoreLibs.constraintLayout)
    implementation(Dependencies.CoreLibs.navigationFragment)
    implementation(Dependencies.CoreLibs.navigationUi)

    implementation(Dependencies.CoreLibs.gson)
    implementation(Dependencies.CoreLibs.coroutines)
    implementation(Dependencies.NetworkLibs.okHttp)
    implementation(Dependencies.NetworkLibs.retrofit)
    implementation(Dependencies.NetworkLibs.retrofitConverterGson)

    implementation(Dependencies.CoreLibs.dagger)
    kapt(Dependencies.CoreLibs.daggerCompiler)

    testImplementation(Dependencies.TestLibs.jUnit)

    androidTestImplementation(Dependencies.TestLibs.jUnitExt)
    androidTestImplementation(Dependencies.TestLibs.espresso)
}
