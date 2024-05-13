package com.stackknowledge.login.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackknowledge.login.LoginActivity
import com.stackknowledge.login.LoginRoute
import com.stackknowledge.login.RoleCheckRoute
import com.stackknowledge.login.RoleCheckScreen

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
    studentCheck: () -> Unit,
    teacherCheck: () -> Unit
) {
    composable(route = roleCheckRoute) {
        RoleCheckRoute(
            studentCheck = studentCheck,
            teacherCheck = teacherCheck
        )
    }
}