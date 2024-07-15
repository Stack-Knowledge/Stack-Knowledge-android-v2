package com.kdn.stack_knowledge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.minstone.ui.navigation.NavigateType
import com.stackknowledge.login.navigation.loginScreen
import com.stackknowledge.login.navigation.navigateToLogin
import com.stackknowledge.login.navigation.roleCheckRoute
import com.stackknowledge.login.navigation.roleCheckScreen
import com.stackknowledge.main.navigation.mainScreen
import com.stackknowledge.main.navigation.navigateToMain
import com.kdn.stack_knowledge.navigation.util.bottomNavigationNavigate
import com.stackknowledge.ranking.navigation.navigateToRanking
import com.stackknowledge.ranking.navigation.navigateToTeacherRanking
import com.stackknowledge.ranking.navigation.rankingScreen
import com.stackknowledge.ranking.navigation.teacherRankingScreen
import com.stackknowledge.score_mission.navigation.gradingAnswerScreen
import com.stackknowledge.score_mission.navigation.navigateToGradingAnswer
import com.stackknowledge.score_mission.navigation.navigateToSolvedMission
import com.stackknowledge.score_mission.navigation.solvedMissionScreen
import com.stackknowledge.shop.navigation.shopRoute
import com.stackknowledge.shop.navigation.shopScreen
import com.stackknowledge.shop.navigation.teacherShopRoute
import com.stackknowledge.shop.navigation.teacherShopScreen
import com.kdn.stack_knowledge.ui.StackKnowledgeAppState
import com.stackknowledge.main.navigation.mainPageRoute
import com.stackkowledge.mission.navigation.createMissionScreen
import com.stackkowledge.mission.navigation.entireMissionScreen
import com.stackkowledge.mission.navigation.navigateToEntireMission
import com.stackkowledge.mission.navigation.navigateToResolveMission
import com.stackkowledge.mission.navigation.resolveMissionScreen
import enumdata.Authority

@Composable
fun StackKnowledgeNavHost(
    appState: StackKnowledgeAppState,
    startDestination: String = roleCheckRoute,
    modifier: Modifier = Modifier,
    onLoginButtonClick: () -> Unit = {},
    onLogout: () -> Unit,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        loginScreen(
            onSuccess = navController::navigateToMain,
            onLoginButtonClick = onLoginButtonClick,
            onDeleteBackStack = {
                navController.navigate(mainPageRoute) {
                    popUpTo(roleCheckRoute) {
                        inclusive = true
                    }
                }
            }
        )
        roleCheckScreen(
            onRoleButtonClick = navController::navigateToLogin
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
            logoutSuccess = onLogout,
            onDeleteBackStack = {
                navController.navigate(mainPageRoute) {
                    popUpTo(roleCheckRoute)
                }
            }
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
            scoreMissionSuccess = navController::navigateToMain,
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