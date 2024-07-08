package com.stackknowledge.ranking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.minstone.ui.navigation.StackKnowledgeBottomNavigation
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.ranking.component.RankingList
import com.stackknowledge.ranking.component.RankingProfile
import com.stackknowledge.ranking.viewModel.RankingViewModel
import com.stackknowledge.ranking.viewModel.uistate.GetMyInformationUiState
import com.stackknowledge.ranking.viewModel.uistate.GetRankingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import enumdatatype.Authority

@Composable
internal fun RankingRoute(
    onNavigate: (Authority, String) -> Unit,
    viewModel: RankingViewModel = hiltViewModel(),
) {
    var role by remember { mutableStateOf(Authority.ROLE_STUDENT) } //로그인 로직 적용후 변경
    val getRankingUiState by viewModel.getRankingUiState.collectAsStateWithLifecycle()
    val getMyInformationUiState by viewModel.getMyInformationUiState.collectAsStateWithLifecycle()

    RankingScreen(
        role = role,
        getRankingUiState = getRankingUiState,
        getMyInformationUiState = getMyInformationUiState,
        onNavigate = { navType -> onNavigate(role, navType) },
        initRanking = {
            with(viewModel) {
                getRanking()
                getMyProfile()
            }
        },
    )
}

@Composable
private fun RankingScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    getRankingUiState: GetRankingUiState,
    getMyInformationUiState: GetMyInformationUiState,
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
                Spacer(modifier = modifier.height(52.dp))
                RankingProfile(
                    getMyInformationUiState = getMyInformationUiState
                )
                Spacer(modifier = modifier.height(61.dp))
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