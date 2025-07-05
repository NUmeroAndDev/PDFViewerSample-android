package jp.numero.pdfviewersample.buildlogic.primitive

import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType
import java.util.Optional

fun DependencyHandlerScope.implementation(
    project: ProjectDependency,
) = add("implementation", project)

fun DependencyHandlerScope.implementation(
    artifact: Optional<Provider<MinimalExternalModuleDependency>>,
) = add("implementation", artifact.get())

fun DependencyHandlerScope.implementation(
    artifact: Provider<MinimalExternalModuleDependency>,
) = add("implementation", artifact)

internal fun DependencyHandlerScope.implementationBundles(
    dependency: Optional<Provider<ExternalModuleDependencyBundle>>,
) = add("implementation", dependency.get())

fun DependencyHandlerScope.debugImplementation(
    artifact: Optional<Provider<MinimalExternalModuleDependency>>,
) = add("debugImplementation", artifact.get())

internal fun DependencyHandlerScope.testImplementationBundles(
    dependency: Optional<Provider<ExternalModuleDependencyBundle>>,
) = add("testImplementation", dependency.get())

fun DependencyHandlerScope.testImplementation(
    project: ProjectDependency,
) = add("testImplementation", project)

fun DependencyHandlerScope.testImplementation(
    artifact: Optional<Provider<MinimalExternalModuleDependency>>,
) = add("testImplementation", artifact.get())

fun DependencyHandlerScope.testImplementation(
    artifact: Provider<MinimalExternalModuleDependency>,
) = add("testImplementation", artifact)

fun DependencyHandlerScope.api(
    artifact: Optional<Provider<MinimalExternalModuleDependency>>,
) = add("api", artifact.get())

fun DependencyHandlerScope.ksp(
    project: ProjectDependency,
) = add("ksp", project)

fun DependencyHandlerScope.ksp(
    dependency: Optional<Provider<MinimalExternalModuleDependency>>,
) = add("ksp", dependency.get())

val Project.libs get() = extensions.getByType<VersionCatalogsExtension>().named("libs")
