package com.stackknowledge.navigation.util

import androidx.navigation.NavController
import com.minstone.ui.navigation.NavigateType
import com.stackknowledge.main.navigation.navigateToMain
import com.stackknowledge.ranking.navigation.navigateToRanking
import com.stackknowledge.ranking.navigation.navigateToTeacherRanking
import com.stackknowledge.resolve_mission.navigation.navigateToResolveMission
import com.stackknowledge.score_mission.navigation.navigateToSolvedMission
import com.stackknowledge.shop.navigation.navigateToShop
import com.stackknowledge.shop.navigation.navigateToTeacherShop
import com.stackkowledge.mission.navigation.navigateToCreateMission
import com.stackkowledge.mission.navigation.navigateToEntireMission
import enumdatatype.Authority

fun bottomNavigationNavigate(
    role: Authority,
    navController: NavController,
    navType: String
) {
    if (role == Authority.ROLE_TEACHER) {
        when(navType) {
            NavigateType.HOME.value -> navController.navigateToMain()
            NavigateType.MISSION.value ->  navController.navigateToSolvedMission()
            NavigateType.CREATE_MISSION.value ->  navController.navigateToCreateMission()
            NavigateType.SHOP.value -> navController.navigateToTeacherShop()
            NavigateType.RANKING.value -> navController.navigateToTeacherRanking()
        }
    } else {
        when(navType) {
            NavigateType.HOME.value -> navController.navigateToMain()
            NavigateType.MISSION.value ->  navController.navigateToEntireMission()
            NavigateType.SHOP.value -> navController.navigateToShop()
            NavigateType.RANKING.value -> navController.navigateToRanking()
        }
    }
}