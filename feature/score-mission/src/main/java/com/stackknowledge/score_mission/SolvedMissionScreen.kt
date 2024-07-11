package com.stackknowledge.score_mission

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.minstone.ui.navigation.StackKnowledgeBottomNavigation
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.score_mission.component.SolvedMissionList
import com.stackknowledge.score_mission.viewmodel.ScoreMissionViewModel
import com.stackknowledge.score_mission.viewmodel.uistate.GetScoreMissionListUiState
import enumdata.Authority

@Composable
internal fun SolvedMissionRoute(
    viewModel: ScoreMissionViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    onNavigate: (Authority, String) -> Unit,
    onItemClick: () -> Unit
) {
    var role by remember { mutableStateOf(Authority.ROLE_TEACHER) } //로그인 로직 적용후 변경
    val scoreMissionListUiState by viewModel.getScoreMissionListUiState.collectAsStateWithLifecycle()

    SolvedMissionScreen(
        role = role,
        onNavigate = { navType -> onNavigate(role, navType) },
        onItemClick = onItemClick,
        intentId = { viewModel.onSolveId(it) },
        getScoreMission = { viewModel.getScoreMissionList() },
        scoreMissionListUiState = scoreMissionListUiState,
    )
}

@Composable
private fun SolvedMissionScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    onNavigate: (String) -> Unit,
    onItemClick: () -> Unit,
    intentId: (String) -> Unit,
    getScoreMission: () -> Unit,
    scoreMissionListUiState: GetScoreMissionListUiState,
) {
    LaunchedEffect(true) {
        getScoreMission()
    }
    StackKnowledgeAndroidTheme { colors, _ ->
        Box {
            Column(
                modifier = modifier
                    .background(color = colors.WHITE)
                    .fillMaxSize()
            ) {
                StackKnowledgeTopBar()

                SolvedMissionList(
                    getScoreMissionListUiState = scoreMissionListUiState,
                    onClick = { onItemClick() },
                    intentId = { intentId(it) }
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
