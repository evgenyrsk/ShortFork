plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    buildToolsVersion = AppConfig.buildToolsVersion
}

dependencies {
    implementation(Dependencies.Kotlin.kotlin_std)

    implementation(Dependencies.CoreLibs.appCompat)
    implementation(Dependencies.CoreLibs.core)
    implementation(Dependencies.CoreLibs.material)
    implementation(Dependencies.CoreLibs.constraintLayout)
    implementation(Dependencies.CoreLibs.navigationFragment)
    implementation(Dependencies.CoreLibs.navigationUi)

    implementation(Dependencies.CoreLibs.coroutines)
    implementation(Dependencies.CoreLibs.coroutinesCore)

    implementation(Dependencies.NetworkLibs.retrofit)
    implementation(Dependencies.NetworkLibs.jsoup)
    implementation(Dependencies.NetworkLibs.retrofitConverterGson)

    api(Dependencies.CoreLibs.dagger)
    kapt(Dependencies.CoreLibs.daggerCompiler)
}
