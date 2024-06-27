package com.stackknowledge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.stackknowledge.login.navigation.loginScreen
import com.stackknowledge.login.navigation.navigateToLogin
import com.stackknowledge.login.navigation.roleCheckRoute
import com.stackknowledge.login.navigation.roleCheckScreen
import com.stackknowledge.ui.StackKnowledgeAppState

@Composable
fun StackKnowledgeNavHost(
    appState: StackKnowledgeAppState,
    startDestination: String = roleCheckRoute,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        roleCheckScreen(
            onRoleButtonClick = navController::navigateToLogin
        )
        loginScreen(

        )
    }
}