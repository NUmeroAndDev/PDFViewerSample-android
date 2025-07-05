package jp.numero.pdfviewersample

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import jp.numero.pdfviewersample.feature.home.homeRoute
import jp.numero.pdfviewersample.feature.home.homeScreen

@Composable
fun TemplateAppNavigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = homeRoute,
    ) {
        homeScreen()
    }
}