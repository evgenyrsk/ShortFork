plugins {
    `java-library`
    kotlin("jvm")
    kotlin("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":core-network-api"))

    implementation(Dependencies.Kotlin.kotlin_std)

    implementation(Dependencies.CoreLibs.gson)
    implementation(Dependencies.CoreLibs.jsoup)
    implementation(Dependencies.CoreLibs.coroutines)

    api(Dependencies.CoreLibs.dagger)
    kapt(Dependencies.CoreLibs.daggerCompiler)

    implementation(Dependencies.NetworkLibs.okHttp)
    implementation(Dependencies.NetworkLibs.retrofit)
    implementation(Dependencies.NetworkLibs.retrofitConverterGson)
}
