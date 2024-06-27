package com.stackknowledge.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackknowledge.login.LoginScreenRoute
import com.stackknowledge.login.RoleCheckScreenRoute

const val LoginRoute = "login_route"
const val RoleCheckRoute = "role_check_route"

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(LoginRoute, navOptions)
}

fun NavGraphBuilder.loginScreen() {
    composable(route = LoginRoute) {
        LoginScreenRoute()
    }
}

fun NavController.navigateToRoleCheck(navOptions: NavOptions? = null) {
    this.navigate(RoleCheckRoute, navOptions)
}

fun NavGraphBuilder.roleCheckScreen() {
    composable(route = RoleCheckRoute) {
        RoleCheckScreenRoute()
    }
}