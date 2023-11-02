plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.yaman.jetpackpractice"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.yaman.jetpackpractice"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            buildConfigField("String", "API_TOKEN", "\"1171086418644515\"")
            buildConfigField("String", "Bearer", "\"Bearer 117#Nerglnw3@@OI)30@I*Dm'@@\"")
            buildConfigField("String", "API_ID", "\"120\"")  //dev
            buildConfigField("String", "THEME", "\"1\"")
            buildConfigField("String", "ACCOUNT_ID", "\"10002396\"")
            buildConfigField("String", "BASE_URL_WEB", "\"https://appapi.videocrypt.in/\"")
            buildConfigField("String", "BASE_URL", "\"https://developer.videocrypt.in/\"")
            buildConfigField("String", "CONGNITO_POOL_ID", "\"ap-south-1:01cbc427-d41d-4cbc-baa6-012c6ff2f540\"")
            buildConfigField("String", "FAQ_URL", "\"NaN\"")
            buildConfigField("String", "AccessKey", "\"NExWQUVLWkoxRlFXMzVNSVlQTjY=\"")
            buildConfigField("String", "SecretKey", "\"VXdNNjdjcHpyeXRsT2ZWbXY9Z3hTYTRBaFFiOUhuQnNHMC9GajJQSQ==\"")
        }
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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.4")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.navigation:navigation-compose:2.7.4")

    /*Room*/
    implementation("androidx.room:room-runtime:2.6.0")
    kapt("androidx.room:room-compiler:2.6.0")

    /*Retrofit*/
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

    /* Country Code Picker */
    implementation("com.hbb20:ccp:2.7.1")

}