import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "jp.numero.pdfviewersample.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.fromTarget(
            JavaVersion.VERSION_17.toString(),
        )
    }
}

dependencies {
    compileOnly(libs.androidGradlePlugin)
    compileOnly(libs.kotlinGradlePlugin)
    compileOnly(libs.kspPlugin)
    implementation(libs.hiltPlugin)
}

gradlePlugin {
    plugins {
        // primitives
        register("androidApplication") {
            id = "buildlogic.primitive.androidapplication"
            implementationClass =
                "jp.numero.pdfviewersample.buildlogic.primitive.AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "buildlogic.primitive.androidlibrary"
            implementationClass =
                "jp.numero.pdfviewersample.buildlogic.primitive.AndroidLibraryPlugin"
        }
        register("compose") {
            id = "buildlogic.primitive.compose"
            implementationClass = "jp.numero.pdfviewersample.buildlogic.primitive.ComposePlugin"
        }
        register("kotlin") {
            id = "buildlogic.primitive.kotlin"
            implementationClass = "jp.numero.pdfviewersample.buildlogic.primitive.KotlinPlugin"
        }
        register("hilt") {
            id = "buildlogic.primitive.hilt"
            implementationClass = "jp.numero.pdfviewersample.buildlogic.primitive.HiltPlugin"
        }

        // conventions
        register("appModule") {
            id = "buildlogic.conventions.appmodule"
            implementationClass = "jp.numero.pdfviewersample.buildlogic.conventions.AppModulePlugin"
        }
        register("featureModule") {
            id = "buildlogic.conventions.featuremodule"
            implementationClass = "jp.numero.pdfviewersample.buildlogic.conventions.FeatureModulePlugin"
        }
    }
}
