/**
 * @author Evgeny Rasskazov
 */
object Dependencies {

    object Kotlin {
        const val kotlin_std7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
        const val kotlin_std = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    }

    object BuildPlugins {
        const val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradle}"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object CoreLibs {
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val material = "com.google.android.material:material:${Versions.meterial}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

        const val gson = "com.google.code.gson:gson:${Versions.gson}"
        const val jsoup = "org.jsoup:jsoup:${Versions.jsoup}"

        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    object NetworkLibs {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val retrofitAdapterRxJava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    }

    object TestLibs {
        const val jUnit = "junit:junit:${Versions.jUnit}"
        const val jUnitExt = "androidx.test.ext:junit:${Versions.extJUnit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }
}
