plugins {
    `java-library`
    kotlin("jvm")
    kotlin("kapt")
}

dependencies {
    implementation(Dependencies.Kotlin.kotlin_std)

    implementation(Dependencies.CoreLibs.gson)

    implementation(Dependencies.NetworkLibs.retrofit)
}
