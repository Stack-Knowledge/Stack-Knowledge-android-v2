package com.stackkowledge.mission

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
import com.stackkowledge.mission.component.EntireMissionList
import com.stackkowledge.mission.viewmodel.MissionViewModel
import com.stackkowledge.mission.viewmodel.uistate.GetMissionUiState
import enumdatatype.Authority

@Composable
internal fun EntireMissionRoute(
    missionViewModel: MissionViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    onNavigate: (Authority, String) -> Unit,
    onItemClick: () -> Unit,
) {
    var role by remember { mutableStateOf(Authority.ROLE_STUDENT) } //로그인 로직 적용후 변경
    val missionUiState by missionViewModel.missionUiState.collectAsStateWithLifecycle()

    EntireMissionScreen(
        role = role,
        onNavigate = { navType -> onNavigate(role, navType) },
        onItemClick = {
            onItemClick()
            missionViewModel.onMissionId(it)
        },
        getMission = { missionViewModel.getMission() },
        missionUiState = missionUiState
    )
}

@Composable
private fun EntireMissionScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    onNavigate: (String) -> Unit,
    onItemClick: (String) -> Unit,
    getMission: () -> Unit,
    missionUiState: GetMissionUiState,
) {
    LaunchedEffect(true) {
        getMission()
    }

    StackKnowledgeAndroidTheme { colors, _ ->
        Box {
            Column(
                modifier = modifier
                    .background(color = colors.WHITE)
                    .fillMaxSize()
            ) {
                StackKnowledgeTopBar()
                EntireMissionList(
                    getMissionUiState = missionUiState,
                    onClick = { onItemClick(it) },
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