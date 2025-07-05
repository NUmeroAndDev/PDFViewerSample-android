package jp.numero.pdfviewersample.feature.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val homeRoute = "home"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    navigate(homeRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
) {
    composable(route = homeRoute) {
        Home()
    }
}
