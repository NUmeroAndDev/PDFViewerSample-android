package jp.numero.pdfviewersample.buildlogic.primitive

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

fun Project.application(action: BaseAppModuleExtension.() -> Unit) {
    extensions.configure(action)
}

fun Project.library(action: LibraryExtension.() -> Unit) {
    extensions.configure(action)
}

fun Project.android(action: BaseExtension.() -> Unit) {
    extensions.configure(action)
}

fun Project.commonConfiguration() {
    android {
        namespace?.let {
            this.namespace = it
        }
        compileSdkVersion(36)

        defaultConfig {
            minSdk = 31
            targetSdk = 36

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        sourceSets {
            getByName("main").java.srcDir("src/main/kotlin")
            getByName("test").java.srcDir("src/test/kotlin")
            getByName("androidTest").java.srcDir("src/androidTest/kotlin")
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        dependencies {
        }

        testOptions {
            unitTests {
                isIncludeAndroidResources = true
            }
        }
    }
}
