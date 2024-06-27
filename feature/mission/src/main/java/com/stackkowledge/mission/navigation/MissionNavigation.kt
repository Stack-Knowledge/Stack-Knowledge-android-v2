package com.stackkowledge.mission.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackkowledge.mission.CreateMissionRoute
import com.stackkowledge.mission.EntireMissionRoute

const val createMissionRoute = "create_mission_route"
const val entireMissionRoute = "entire_mission_route"

fun NavController.navigateToCreateMission(navOptions: NavOptions? = null) {
    this.navigate(createMissionRoute, navOptions)
}

fun NavGraphBuilder.createMissionScreen() {
    composable(route = createMissionRoute) {
        CreateMissionRoute()
    }
}

fun NavController.navigateToEntireMission(navOptions: NavOptions? = null) {
    this.navigate(entireMissionRoute, navOptions)
}

fun NavGraphBuilder.entireMissionScreen() {
    composable(route = entireMissionRoute) {
        EntireMissionRoute()
    }
}