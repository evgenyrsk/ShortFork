plugins {
    `java-library`
    kotlin("jvm")
    kotlin("kapt")
}

dependencies {
    implementation(Dependencies.Kotlin.kotlin_std)

    implementation(Dependencies.CoreLibs.gson)
    implementation(Dependencies.CoreLibs.dagger)
    implementation(Dependencies.CoreLibs.daggerCompiler)

    implementation(Dependencies.NetworkLibs.retrofit)
    implementation(Dependencies.NetworkLibs.retrofitConverterGson)
}
