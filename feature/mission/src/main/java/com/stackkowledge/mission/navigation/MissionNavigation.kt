package com.stackkowledge.mission.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackkowledge.mission.CreateMissionRoute
import com.stackkowledge.mission.EntireMissionRoute

const val CreateMission = "create_mission_route"
const val EntireMission = "entire_mission_route"

fun NavController.navigateToCreateMission(navOptions: NavOptions? = null) {
    this.navigate(CreateMission, navOptions)
}

fun NavGraphBuilder.loginScreen() {
    composable(route = CreateMission) {
        CreateMissionRoute()
    }
}

fun NavController.navigateToEntireMission(navOptions: NavOptions? = null) {
    this.navigate(EntireMission, navOptions)
}

fun NavGraphBuilder.roleCheckScreen() {
    composable(route = EntireMission) {
        EntireMissionRoute()
    }
}