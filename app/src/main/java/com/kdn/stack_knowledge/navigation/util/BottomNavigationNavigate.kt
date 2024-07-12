package com.kdn.stack_knowledge.navigation.util

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.navOptions
import com.minstone.ui.navigation.NavigateType
import com.stackknowledge.main.navigation.navigateToMain
import com.stackknowledge.ranking.navigation.navigateToRanking
import com.stackknowledge.ranking.navigation.navigateToTeacherRanking
import com.stackknowledge.score_mission.navigation.navigateToSolvedMission
import com.stackknowledge.shop.navigation.navigateToShop
import com.stackknowledge.shop.navigation.navigateToTeacherShop
import com.stackkowledge.mission.navigation.navigateToCreateMission
import com.stackkowledge.mission.navigation.navigateToEntireMission
import enumdata.Authority

fun bottomNavigationNavigate(
    role: Authority,
    navController: NavController,
    navType: String
) {
    val topLevelNavOptions = navOptions {
        popUpTo(navController.graph.findStartDestination().id) {
            inclusive = false
        }
        launchSingleTop = true
        restoreState = true
    }

    if (role == Authority.ROLE_TEACHER) {
        when(navType) {
            NavigateType.HOME.value -> navController.navigateToMain(topLevelNavOptions)
            NavigateType.MISSION.value ->  navController.navigateToSolvedMission(topLevelNavOptions)
            NavigateType.CREATE_MISSION.value ->  navController.navigateToCreateMission(topLevelNavOptions)
            NavigateType.SHOP.value -> navController.navigateToTeacherShop(topLevelNavOptions)
            NavigateType.RANKING.value -> navController.navigateToTeacherRanking(topLevelNavOptions)
        }
    } else {
        when(navType) {
            NavigateType.HOME.value -> navController.navigateToMain(topLevelNavOptions)
            NavigateType.MISSION.value ->  navController.navigateToEntireMission(topLevelNavOptions)
            NavigateType.SHOP.value -> navController.navigateToShop(topLevelNavOptions)
            NavigateType.RANKING.value -> navController.navigateToRanking(topLevelNavOptions)
        }
    }
}