plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(AppConfig.compileSdkVersion)
    buildToolsVersion(AppConfig.buildToolsVersion)
}

dependencies {
    implementation(project(":core-android"))
    implementation(project(":core-network-api"))
    implementation(project(":feature-board-api"))

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

    api(Dependencies.CoreLibs.dagger)
    kapt(Dependencies.CoreLibs.daggerCompiler)

    testImplementation(Dependencies.TestLibs.jUnit)

    androidTestImplementation(Dependencies.TestLibs.jUnitExt)
    androidTestImplementation(Dependencies.TestLibs.espresso)
    //    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.2.0'
    //    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'
}
