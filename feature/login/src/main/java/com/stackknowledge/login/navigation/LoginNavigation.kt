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

fun NavGraphBuilder.loginScreen(
    onSuccess: () -> Unit = {},
    onLoginButtonClick: () -> Unit = {},
    onDeleteBackStack: () -> Unit,
) {
    composable(route = loginRoute) {
        LoginRoute(
            onSuccess = onSuccess,
            onGoogleLoginButtonClicked = onLoginButtonClick,
            onDeleteBackStack = onDeleteBackStack,
        )
    }
}

fun NavController.navigateToRoleCheck(navOptions: NavOptions? = null) {
    this.navigate(roleCheckRoute, navOptions)
}

fun NavGraphBuilder.roleCheckScreen(
    onRoleButtonClick: () -> Unit,
) {
    composable(route = roleCheckRoute) {
        RoleCheckRoute(
            onRoleButtonClick = onRoleButtonClick
        )
    }
}