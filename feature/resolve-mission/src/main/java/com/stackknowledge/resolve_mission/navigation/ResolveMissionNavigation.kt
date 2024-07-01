package com.stackknowledge.resolve_mission.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackknowledge.resolve_mission.ResolveMissionRoute
import enumdatatype.Authority

const val resolveMissionRoute = "resolve_mission_route"

fun NavController.navigateToResolveMission(navOptions: NavOptions? = null) {
    this.navigate(resolveMissionRoute, navOptions)
}

fun NavGraphBuilder.resolveMissionScreen(
    onNavigate: (Authority, String) -> Unit,
) {
    composable(route = resolveMissionRoute) {
        ResolveMissionRoute(
            onNavigate = onNavigate
        )
    }
}