plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    id("kotlin-kapt")
    id ("kotlin-android")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.myapplication22"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myapplication22"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation("io.coil-kt:coil-compose:2.4.0")

    // date picker
    implementation (libs.jalali.datepicker.compose)
    implementation (libs.jalalicalendar)


//    // room
//    implementation ("androidx.room:room-runtime:2.5.2")
//    annotationProcessor ("androidx.room:room-compiler:2.5.2")
//    kapt( "androidx.room:room-compiler:2.5.2")
//
//    // Optional: برای پشتیبانی از کوروتین
//    implementation( "androidx.room:room-ktx:2.5.2")

    // hilt
//    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0")
//    kapt( "androidx.hilt:hilt-compiler:2.46.1")
//    implementation ("com.google.dagger:hilt-android:2.46.1")
//    kapt ("com.google.dagger:hilt-android-compiler:2.46.1")

//
    implementation ("androidx.compose.material:material-icons-extended")
//
//
//    implementation("androidx.compose.ui:ui:1.5.0")
//    implementation("androidx.compose.material:material:1.5.0")
//    implementation("androidx.compose.ui:ui-tooling:1.5.0")
//
//
//    implementation ("androidx.room:room-runtime:2.5.2")
//    kapt ("androidx.room:room-compiler:2.5.2")
//    implementation( "androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
//    implementation( "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
//    implementation ("androidx.room:room-ktx:2.5.2")
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1") // یا جدیدترین نسخه



//    // Room
//    implementation ("androidx.room:room-runtime:2.5.2")
//    kapt( "androidx.room:room-compiler:2.5.2")
//    implementation( "androidx.room:room-ktx:2.5.2")
//
//    // Hilt
//    implementation ("com.google.dagger:hilt-android:2.48")
//    kapt ("com.google.dagger:hilt-compiler:2.48")
//
//    // Lifecycle for LiveData
//    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
//
//    // Compose ViewModel integration
//    implementation( "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")



    // Room
    implementation ("androidx.room:room-runtime:2.5.2")
    kapt ("androidx.room:room-compiler:2.5.2")
    implementation ("androidx.room:room-ktx:2.5.2")

    // Hilt
    implementation ("com.google.dagger:hilt-android:2.47")
    kapt ("com.google.dagger:hilt-android-compiler:2.47")

    // Lifecycle (برای LiveData)
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation ("com.google.dagger:dagger:2.47")
    kapt ("com.google.dagger:dagger-compiler:2.47")


    // Hilt for Jetpack Compose
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Compose
    implementation ("androidx.compose.ui:ui:1.6.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
}
