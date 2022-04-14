plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }
    buildFeatures {
        viewBinding = true
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
    implementation(project(":core-ui"))
    implementation(project(":core"))
    implementation(project(":core-android"))

    implementation(Dependencies.Kotlin.kotlin_std)

    implementation(Dependencies.CoreLibs.appCompat)
    implementation(Dependencies.CoreLibs.core)
    implementation(Dependencies.CoreLibs.material)
    implementation(Dependencies.CoreLibs.constraintLayout)
    implementation(Dependencies.CoreLibs.navigationFragment)
    implementation(Dependencies.CoreLibs.navigationUi)
    implementation(Dependencies.CoreLibs.viewModelSavedState)

    implementation(Dependencies.CoreLibs.gson)
    implementation(Dependencies.CoreLibs.coroutines)

    implementation(Dependencies.NetworkLibs.okHttp)
    implementation(Dependencies.NetworkLibs.retrofit)
    implementation(Dependencies.NetworkLibs.retrofitConverterGson)
    implementation(Dependencies.NetworkLibs.jsoup)

    api(Dependencies.CoreLibs.dagger)
    kapt(Dependencies.CoreLibs.daggerCompiler)

    testImplementation(Dependencies.TestLibs.jUnit)

    androidTestImplementation(Dependencies.TestLibs.jUnitExt)
    androidTestImplementation(Dependencies.TestLibs.espresso)
    //    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.2.0'
    //    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'
}
