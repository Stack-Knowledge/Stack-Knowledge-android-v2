package com.stackknowledge.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackknowledge.login.LoginRoute
import com.stackknowledge.login.RoleCheckRoute

const val loginRoute = "login_route"
const val roleCheckRoute = "role_check_route"

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(loginRoute, navOptions)
}

fun NavGraphBuilder.loginScreen() {
    composable(route = loginRoute) {
        LoginRoute()
    }
}

fun NavController.navigateToRoleCheck(navOptions: NavOptions? = null) {
    this.navigate(roleCheckRoute, navOptions)
}

fun NavGraphBuilder.roleCheckScreen(
) {
    composable(route = roleCheckRoute) {
        RoleCheckRoute(

        )
    }
}