package com.stackknowledge.ranking.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackknowledge.ranking.RankingRoute
import com.stackknowledge.ranking.TeacherRankingRoute

const val Ranking = "ranking_route"
const val TeacherRanking = "teacher_ranking_route"

fun NavController.navigateToCreateMission(navOptions: NavOptions? = null) {
    this.navigate(Ranking, navOptions)
}

fun NavGraphBuilder.loginScreen() {
    composable(route = Ranking) {
        RankingRoute()
    }
}

fun NavController.navigateToEntireMission(navOptions: NavOptions? = null) {
    this.navigate(TeacherRanking, navOptions)
}

fun NavGraphBuilder.roleCheckScreen() {
    composable(route = TeacherRanking) {
        TeacherRankingRoute()
    }
}