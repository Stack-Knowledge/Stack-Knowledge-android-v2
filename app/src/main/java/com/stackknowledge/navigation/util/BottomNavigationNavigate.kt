package com.stackknowledge.navigation.util

import androidx.navigation.NavController
import com.stackknowledge.design_system.component.navigation.NavigateType
import com.stackknowledge.main.navigation.navigateToMain
import com.stackknowledge.ranking.navigation.navigateToRanking
import com.stackknowledge.shop.navigation.navigateToShop
import com.stackkowledge.mission.navigation.navigateToCreateMission
import com.stackkowledge.mission.navigation.navigateToEntireMission
fun bottomNavigationNavigate(
    navController: NavController,
    navType: String
) {
    when(navType) {
        NavigateType.HOME.value -> navController.navigateToMain()
        NavigateType.MISSION.value -> navController.navigateToEntireMission()
        NavigateType.CREATE_MISSION.value -> navController.navigateToCreateMission()
        NavigateType.SHOP.value -> navController.navigateToShop()
        NavigateType.RANKING.value -> navController.navigateToRanking()
    }
}