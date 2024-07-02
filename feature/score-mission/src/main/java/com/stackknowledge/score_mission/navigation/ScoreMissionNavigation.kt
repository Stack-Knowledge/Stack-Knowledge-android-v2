package com.stackknowledge.score_mission.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackknowledge.score_mission.GradingAnswerRoute
import com.stackknowledge.score_mission.SolvedMissionRoute
import enumdatatype.Authority

const val gradingAnswerRoute = "grading_answer_route"
const val solvedMissionRoute = "solved_mission_route"

fun NavController.navigateToGradingAnswer(navOptions: NavOptions? = null) {
    this.navigate(gradingAnswerRoute, navOptions)
}

fun NavGraphBuilder.gradingAnswerScreen() {
    composable(route = gradingAnswerRoute) {
        GradingAnswerRoute()
    }
}

fun NavController.navigateToSolvedMission(navOptions: NavOptions? = null) {
    this.navigate(solvedMissionRoute, navOptions)
}

fun NavGraphBuilder.solvedMissionScreen(
    onNavigate: (Authority, String) -> Unit,
) {
    composable(route = solvedMissionRoute) {
        SolvedMissionRoute(
            onNavigate = onNavigate
        )
    }
}