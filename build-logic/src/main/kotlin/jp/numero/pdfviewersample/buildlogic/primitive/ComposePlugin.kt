package jp.numero.pdfviewersample.buildlogic.primitive

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class ComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.plugin.compose")
            }
            android {
                buildFeatures.compose = true
            }
            dependencies {
                implementation(libs.findLibrary("androidxComposeUi"))
                implementation(libs.findLibrary("androidxComposeUiToolingPreview"))
                implementation(libs.findLibrary("androidxComposeFoundation"))
                implementation(libs.findLibrary("androidxComposeMaterial3"))
                implementation(libs.findLibrary("androidxComposeMaterial3Adaptive"))

                testImplementation(libs.findLibrary("androidxComposeUiTest"))

                debugImplementation(libs.findLibrary("androidxComposeUiTooling"))

                implementation(libs.findLibrary("androidxActivity"))
                implementation(libs.findLibrary("androidxNavigationCompose"))
                implementation(libs.findLibrary("androidxLifecycleViewModel"))
                implementation(libs.findLibrary("androidxHiltNavigationCompose"))
            }
        }
    }
}
