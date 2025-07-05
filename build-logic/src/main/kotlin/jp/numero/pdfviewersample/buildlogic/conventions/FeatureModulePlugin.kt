package jp.numero.pdfviewersample.buildlogic.conventions

import jp.numero.pdfviewersample.buildlogic.primitive.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class FeatureModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("buildlogic.primitive.androidlibrary")
                apply("buildlogic.primitive.compose")
                apply("buildlogic.primitive.kotlin")
                apply("buildlogic.primitive.hilt")
            }
            dependencies {
                implementation(project(":data"))
            }
        }
    }
}