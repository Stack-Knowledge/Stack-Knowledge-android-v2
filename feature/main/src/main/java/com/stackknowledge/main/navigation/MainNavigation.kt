package com.stackknowledge.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackknowledge.main.MainPageRoute
import enumdata.Authority

const val mainPageRoute = "main_page_route"

fun NavController.navigateToMain(navOptions: NavOptions? = null) {
    this.navigate(mainPageRoute, navOptions)
}

fun NavGraphBuilder.mainScreen(
    onNavigate: (Authority, String, Int?) -> Unit,
    logoutSuccess: () -> Unit,
) {
    composable(route = mainPageRoute) {
        MainPageRoute(
            onNavigate = onNavigate,
            logoutSuccess = logoutSuccess,
        )
    }
}