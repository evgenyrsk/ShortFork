plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(AppConfig.compileSdkVersion)
    buildToolsVersion(AppConfig.buildToolsVersion)

    //    defaultConfig {
    //        applicationId(AppConfig.applicationId)
    //        minSdkVersion(AppConfig.minSdkVersion)
    //        targetSdkVersion(AppConfig.targetSdkVersion)
    //        versionCode(AppConfig.versionCode)
    //        versionName(AppConfig.versionName)
    //
    //        testInstrumentationRunner(AppConfig.androidTestInstrumentation)
    //    }
    //
    //    buildTypes {
    //        getByName("release") {
    //            isMinifyEnabled = false
    //            proguardFiles(
    //                getDefaultProguardFile("proguard-android-optimize.txt"),
    //                "proguard-rules.pro"
    //            )
    //        }
    //    }
    //    kotlinOptions {
    //        jvmTarget = JavaVersion.VERSION_1_8.toString()
    //    }
    //    compileOptions {
    //        sourceCompatibility = JavaVersion.VERSION_1_8
    //        targetCompatibility = JavaVersion.VERSION_1_8
    //    }
}

dependencies {

    implementation(Dependencies.Kotlin.kotlin_std)

    implementation(Dependencies.CoreLibs.appCompat)
    implementation(Dependencies.CoreLibs.core)
    implementation(Dependencies.CoreLibs.material)
    implementation(Dependencies.CoreLibs.constraintLayout)
    implementation(Dependencies.CoreLibs.navigationFragment)
    implementation(Dependencies.CoreLibs.navigationUi)

    implementation(Dependencies.CoreLibs.gson)
    implementation(Dependencies.CoreLibs.coroutines)

    testImplementation(Dependencies.TestLibs.jUnit)

    androidTestImplementation(Dependencies.TestLibs.jUnitExt)
    androidTestImplementation(Dependencies.TestLibs.espresso)
    //    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.2.0'
    //    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'
}
