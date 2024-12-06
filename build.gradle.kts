// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath( "com.android.tools.build:gradle:8.1.1")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.47") // اضافه کردن این خط
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}

