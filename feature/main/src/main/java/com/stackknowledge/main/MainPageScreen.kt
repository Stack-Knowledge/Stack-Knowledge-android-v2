package com.stackknowledge.main

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.stackknowledge.design_system.component.dialog.JoinWaitingDialog
import com.stackknowledge.design_system.component.dialog.StackKnowledgeDialog
import com.stackknowledge.design_system.component.topbar.LogoutTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.main.component.JoinWaitingButton
import com.stackknowledge.main.component.MissionList
import com.stackknowledge.main.component.RankingList
import com.stackknowledge.main.component.StackKnowledgePager
import com.stackknowledge.main.viewModel.MainViewModel
import com.stackknowledge.main.viewModel.uistate.GetMissionUiState
import com.stackknowledge.main.viewModel.uistate.GetRankingUiState
import enumdata.Authority

@Composable
internal fun MainPageRoute(
    onNavigate: (Authority, String) -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {
    var role by remember { mutableStateOf(Authority.ROLE_TEACHER) } //로그인 로직 적용후 변경
    val getMissionUiState by viewModel.getMissionUiState.collectAsStateWithLifecycle()
    val getRankingUiState by viewModel.getRankingUiState.collectAsStateWithLifecycle()

    MainPageScreen(
        role = role,
        getMissionUiState = getMissionUiState,
        getRankingUiState = getRankingUiState,
        onNavigate = { navType -> onNavigate(role, navType) },
        initMain = {
            with(viewModel) {
                getMission()
                getRanking()
            }
        }
    )
}

@Composable
private fun MainPageScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    getMissionUiState: GetMissionUiState,
    getRankingUiState: GetRankingUiState,
    onNavigate: (String) -> Unit,
    initMain: () -> Unit,
) {
    val scrollState = rememberScrollState()

    var openDialog by remember { mutableStateOf(false) }
    var openLogoutDialog by remember { mutableStateOf(false) }
    LaunchedEffect("initMain") {
        initMain()
    }

    StackKnowledgeAndroidTheme { colors, _ ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = colors.WHITE)
        ) {
            Column {
                LogoutTopBar(
                    onLogout = { openLogoutDialog = true }
                )
                Column(
                    modifier = modifier.verticalScroll(scrollState)
                ) {
                    StackKnowledgePager()
                    Spacer(modifier = modifier.height(28.dp))
                    MissionList(
                        getMissionUiState = getMissionUiState
                    )
                    Spacer(modifier = modifier.height(20.dp))
                    RankingList(
                        getRankingUiState = getRankingUiState
                    )
                }
            }
            Box(modifier = Modifier.align(alignment = Alignment.BottomEnd)) {
                JoinWaitingButton(
                    modifier = modifier.padding(bottom = 96.dp, end = 8.dp),
                    onClick = { openDialog = true }
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
        if (openLogoutDialog) {
            StackKnowledgeDialog(
                content = "로그아웃 하시겠습니까?",
                onConfirm = { openLogoutDialog = false },
                onDismiss = { openLogoutDialog = false },
                onStateChange = { openLogoutDialog = it },
                openDialog = openLogoutDialog,
            )
        }
        if (openDialog) {
            JoinWaitingDialog(
                openDialog = openDialog,
                onStateChange = { openDialog = it },
                onAccept = {},
                onRefuse = {}
            )
        }
    }
}