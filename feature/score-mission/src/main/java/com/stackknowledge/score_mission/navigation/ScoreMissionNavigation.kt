package com.stackknowledge.score_mission.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackknowledge.score_mission.GradingAnswerRoute
import com.stackknowledge.score_mission.SolvedMissionRoute

const val gradingAnswer = "grading_answer_route"
const val solvedMission = "solved_mission"

fun NavController.navigateToGradingAnswer(navOptions: NavOptions? = null) {
    this.navigate(gradingAnswer, navOptions)
}

fun NavGraphBuilder.gradingAnswerScreen() {
    composable(route = gradingAnswer) {
        GradingAnswerRoute()
    }
}

fun NavController.navigateToSolvedMission(navOptions: NavOptions? = null) {
    this.navigate(solvedMission, navOptions)
}

fun NavGraphBuilder.solvedMissionScreen() {
    composable(route = solvedMission) {
        SolvedMissionRoute()
    }
}