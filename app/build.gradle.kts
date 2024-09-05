@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    kotlin("kapt")
    alias(libs.plugins.safeargs)
}

android {
    namespace = "com.igdel.countin"
    compileSdk = 34
    buildFeatures.buildConfig = true


    defaultConfig {
        applicationId = "com.igdel.countin"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String", "BASE_URL", "\"https://myaiprofesor.com/\"".toString())
        buildConfigField("String", "PUBLIC_URL", "\"https://hackvlc-aforo.pages.dev/\"".toString())

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    lintOptions {
        disable("NotificationPermission")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    dataBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.coroutines)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.retrofit)
    implementation(libs.gsonconverter)
    implementation(libs.okhttp)
    implementation(libs.koinandroid)
    implementation(libs.lifecycle)
    implementation(libs.viewmodel)
    implementation(libs.commonjava8)
    implementation(libs.okhttp)
    implementation(libs.interceptor)
    implementation(libs.zxing.android.embedded)
    implementation(libs.glide)
    implementation(libs.core.splashscreen)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}