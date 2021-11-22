// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlinVersion by extra(Versions.kotlin)
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.BuildPlugins.androidGradle)
        classpath(Dependencies.BuildPlugins.kotlinGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.android.tools.build:gradle:${Versions.androidGradle}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
