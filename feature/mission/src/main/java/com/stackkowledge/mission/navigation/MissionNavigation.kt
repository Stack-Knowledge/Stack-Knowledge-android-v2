package com.stackkowledge.mission.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackkowledge.mission.ResolveMissionRoute
import com.stackkowledge.mission.CreateMissionRoute
import com.stackkowledge.mission.EntireMissionRoute
import enumdatatype.Authority

const val createMissionRoute = "create_mission_route"
const val entireMissionRoute = "entire_mission_route"
const val resolveMissionRoute = "resolve_mission_route"

fun NavController.navigateToCreateMission(navOptions: NavOptions? = null) {
    this.navigate(createMissionRoute, navOptions)
}

fun NavGraphBuilder.createMissionScreen(
    onNavigate: (Authority, String) -> Unit,
    onToMain: () -> Unit,
) {
    composable(route = createMissionRoute) {
        CreateMissionRoute(
            onNavigate = onNavigate,
            onToMain = onToMain
        )
    }
}

fun NavController.navigateToEntireMission(navOptions: NavOptions? = null) {
    this.navigate(entireMissionRoute, navOptions)
}

fun NavGraphBuilder.entireMissionScreen(
    onNavigate: (Authority, String) -> Unit,
    onItemClick: () -> Unit,
) {
    composable(route = entireMissionRoute) {
        EntireMissionRoute(
            onNavigate = onNavigate,
            onItemClick = onItemClick
        )
    }
}

fun NavController.navigateToResolveMission(navOptions: NavOptions? = null) {
    this.navigate(resolveMissionRoute, navOptions)
}

fun NavGraphBuilder.resolveMissionScreen(
    onNavigate: (Authority, String) -> Unit,
    onBackClick: () -> Unit,
    onToMain: () -> Unit,
) {
    composable(route = resolveMissionRoute) {
        ResolveMissionRoute(
            onNavigate = onNavigate,
            onBackClick = onBackClick,
            onToMain = onToMain
        )
    }
}