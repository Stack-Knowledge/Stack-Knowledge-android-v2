package com.stackknowledge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.minstone.ui.navigation.NavigateType
import com.stackknowledge.login.navigation.loginScreen
import com.stackknowledge.login.navigation.navigateToLogin
import com.stackknowledge.login.navigation.roleCheckRoute
import com.stackknowledge.login.navigation.roleCheckScreen
import com.stackknowledge.main.navigation.mainPageRoute
import com.stackknowledge.main.navigation.mainScreen
import com.stackknowledge.main.navigation.navigateToMain
import com.stackknowledge.navigation.util.bottomNavigationNavigate
import com.stackknowledge.ranking.navigation.navigateToRanking
import com.stackknowledge.ranking.navigation.navigateToTeacherRanking
import com.stackknowledge.ranking.navigation.rankingScreen
import com.stackknowledge.ranking.navigation.teacherRankingScreen
import com.stackknowledge.score_mission.navigation.gradingAnswerScreen
import com.stackknowledge.score_mission.navigation.navigateToGradingAnswer
import com.stackknowledge.score_mission.navigation.navigateToSolvedMission
import com.stackknowledge.score_mission.navigation.solvedMissionScreen
import com.stackknowledge.shop.navigation.shopScreen
import com.stackknowledge.shop.navigation.teacherShopScreen
import com.stackknowledge.ui.StackKnowledgeAppState
import com.stackkowledge.mission.navigation.createMissionRoute
import com.stackkowledge.mission.navigation.createMissionScreen
import com.stackkowledge.mission.navigation.entireMissionRoute
import com.stackkowledge.mission.navigation.entireMissionScreen
import com.stackkowledge.mission.navigation.navigateToEntireMission
import com.stackkowledge.mission.navigation.navigateToResolveMission
import com.stackkowledge.mission.navigation.resolveMissionScreen
import enumdatatype.Authority

@Composable
fun StackKnowledgeNavHost(
    appState: StackKnowledgeAppState,
    modifier: Modifier = Modifier,
    startDestination: String = roleCheckRoute,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        loginScreen()
        roleCheckScreen(
            onRoleClick = navController::navigateToLogin
        )
        mainScreen(
            onNavigate = { role, navType, index ->
                if (index != null) {
                    if (navType == NavigateType.MISSION.value) {
                        if (role == Authority.ROLE_STUDENT) navController.navigateToEntireMission()
                        else navController.navigateToSolvedMission()
                    } else {
                        if (role == Authority.ROLE_STUDENT) navController.navigateToRanking()
                        else navController.navigateToTeacherRanking()
                    }
                } else bottomNavigationNavigate(role, navController, navType)
            },
        )
        createMissionScreen(
            onNavigate = { role, navType -> bottomNavigationNavigate(role, navController, navType) },
            createMissionSuccess = navController::navigateToMain
        )
        entireMissionScreen(
            onNavigate = { role, navType -> bottomNavigationNavigate(role, navController, navType) },
            onItemClick = navController::navigateToResolveMission
        )
        rankingScreen(
            onNavigate = { role, navType -> bottomNavigationNavigate(role, navController, navType) }
        )
        teacherRankingScreen(
            onNavigate = { role, navType -> bottomNavigationNavigate(role, navController, navType) }
        )
        resolveMissionScreen(
            onNavigate = { role, navType -> bottomNavigationNavigate(role, navController, navType) },
            onBackClick = navController::popBackStack,
            solveMissionSuccess = navController::navigateToMain,
        )
        gradingAnswerScreen(
            onNavigate = { role, navType -> bottomNavigationNavigate(role, navController, navType) },
        )
        solvedMissionScreen(
            onNavigate = { role, navType -> bottomNavigationNavigate(role, navController, navType) },
            onItemClick = navController::navigateToGradingAnswer
        )
        shopScreen(
            onNavigate = { role, navType -> bottomNavigationNavigate(role, navController, navType) }
        )
        teacherShopScreen(
            onNavigate = { role, navType -> bottomNavigationNavigate(role, navController, navType) }
        )
    }
}