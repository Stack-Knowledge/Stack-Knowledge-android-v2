package com.stackknowledge.ranking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.minstone.ui.navigation.StackKnowledgeBottomNavigation
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.ranking.component.RankingList
import enumdata.Authority
import com.stackknowledge.ranking.viewmodel.RankingViewModel
import com.stackknowledge.ranking.viewmodel.uistate.GetRankingUiState

@Composable
internal fun TeacherRankingRoute(
    onNavigate: (Authority, String) -> Unit,
    viewModel: RankingViewModel = hiltViewModel(),
) {
    var role by remember { mutableStateOf(Authority.ROLE_TEACHER) } //로그인 로직 적용후 변경
    val getRankingUiState by viewModel.getRankingUiState.collectAsStateWithLifecycle()

    TeacherRankingScreen(
        role = role,
        getRankingUiState = getRankingUiState,
        onNavigate = { navType -> onNavigate(role, navType) },
        initRanking = viewModel::getRanking
    )
}

@Composable
private fun TeacherRankingScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    getRankingUiState: GetRankingUiState,
    onNavigate: (String) -> Unit,
    initRanking: () -> Unit,
) {
    LaunchedEffect("initRanking") {
        initRanking()
    }

    StackKnowledgeAndroidTheme { colors, _ ->
        Box {
            Column(
                modifier = modifier
                    .background(color = colors.WHITE)
                    .fillMaxSize()
            ) {
                StackKnowledgeTopBar()

                Spacer(modifier = modifier.height(36.dp))

                RankingList(
                    getRankingUiState = getRankingUiState
                )
            }
            Box(
                modifier = Modifier.align(alignment = Alignment.BottomCenter),
            ) {
                StackKnowledgeBottomNavigation(
                    modifier = Modifier,
                    role = role
                ) {
                    onNavigate(it)
                }
            }
        }
    }
}