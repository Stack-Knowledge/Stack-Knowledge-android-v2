package com.stackknowledge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.stackknowledge.login.navigation.loginScreen
import com.stackknowledge.login.navigation.roleCheckScreen
import com.stackknowledge.main.navigation.mainPageRoute
import com.stackknowledge.main.navigation.mainScreen
import com.stackknowledge.ranking.navigation.rankingScreen
import com.stackknowledge.ranking.navigation.teacherRankingScreen
import com.stackknowledge.resolve_mission.navigation.resolveMissionScreen
import com.stackknowledge.score_mission.navigation.gradingAnswerScreen
import com.stackknowledge.score_mission.navigation.solvedMissionScreen
import com.stackknowledge.shop.navigation.shopScreen
import com.stackknowledge.shop.navigation.teacherShopScreen
import com.stackknowledge.ui.StackKnowledgeAppState
import com.stackkowledge.mission.navigation.createMissionScreen
import com.stackkowledge.mission.navigation.entireMissionScreen

@Composable
fun StackKnowledgeNavHost(
    appState: StackKnowledgeAppState,
    modifier: Modifier = Modifier,
    startDestination: String = mainPageRoute, // = 선생여부 묻는 스크린 Route <- 루트 추가
) {
    val navController = appState.navController

    // 아래의 NavHost의 startDestination은 GoogleOAuth작업 이후 학생 or 선생여부 묻는 스크린을 띄워주면 될 거 같아요
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        loginScreen()
        roleCheckScreen()
        mainScreen(
            onHomeClick = {},
            onMissionClick = {},
            onMakeMissionClick = {},
            onShopClick = {},
            onRankingClick = {},
        )
        createMissionScreen()
        entireMissionScreen()
        rankingScreen()
        teacherRankingScreen()
        resolveMissionScreen()
        gradingAnswerScreen()
        solvedMissionScreen()
        shopScreen()
        teacherShopScreen()
    }
}