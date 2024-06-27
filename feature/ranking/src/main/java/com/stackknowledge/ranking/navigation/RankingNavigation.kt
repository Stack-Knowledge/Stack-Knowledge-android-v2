package com.stackknowledge.ranking.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stackknowledge.ranking.RankingRoute
import com.stackknowledge.ranking.TeacherRankingRoute

const val rankingRoute = "ranking_route"
const val teacherRankingRoute = "teacher_ranking_route"

fun NavController.navigateToRanking(navOptions: NavOptions? = null) {
    this.navigate(rankingRoute, navOptions)
}

fun NavGraphBuilder.rankingScreen() {
    composable(route = rankingRoute) {
        RankingRoute()
    }
}

fun NavController.navigateToTeacherRanking(navOptions: NavOptions? = null) {
    this.navigate(teacherRankingRoute, navOptions)
}

fun NavGraphBuilder.teacherRankingScreen() {
    composable(route = teacherRankingRoute) {
        TeacherRankingRoute()
    }
}