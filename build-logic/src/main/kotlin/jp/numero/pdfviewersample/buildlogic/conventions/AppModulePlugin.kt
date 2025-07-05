package jp.numero.pdfviewersample.buildlogic.conventions

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
class AppModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("buildlogic.primitive.androidapplication")
                apply("buildlogic.primitive.compose")
                apply("buildlogic.primitive.kotlin")
                apply("buildlogic.primitive.hilt")
            }
            dependencies {
            }
        }
    }
}