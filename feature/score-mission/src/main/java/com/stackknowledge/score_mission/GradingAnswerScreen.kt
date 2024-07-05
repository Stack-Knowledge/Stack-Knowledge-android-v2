package com.stackknowledge.score_mission

import androidx.activity.ComponentActivity
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.minstone.ui.navigation.StackKnowledgeBottomNavigation
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.score_mission.component.GradingRadioButton
import com.stackknowledge.score_mission.component.SolvedMissionAnswer
import com.stackknowledge.score_mission.component.SolvedMissionTitle
import com.stackknowledge.score_mission.viewmodel.ScoreMissionViewModel
import com.stackknowledge.score_mission.viewmodel.uistate.DetailScoreMissionUiState
import enumdatatype.Authority
import enumdatatype.SolveStatus
import remote.request.user.ScoreRequestModel

@Composable
internal fun GradingAnswerRoute(
    viewModel: ScoreMissionViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    onNavigate: (Authority, String) -> Unit,
) {
    var role by remember { mutableStateOf(Authority.ROLE_TEACHER) } //로그인 로직 적용후 변경
    val detailSolveMissionUiState by viewModel.detailScoreMissionUiState.collectAsStateWithLifecycle()
    lateinit var solveStatus: SolveStatus

    GradingAnswerScreen(
        role = role,
        onNavigate = { navType -> onNavigate(role, navType) },
        onAnswer = {
            solveStatus = SolveStatus.CORRECT_ANSWER
        },
        onWrongAnswer = {
            solveStatus = SolveStatus.WRONG_ANSWER
        },
        onSolveMission = {
            when (solveStatus) {
                SolveStatus.CORRECT_ANSWER -> {
                    viewModel.scoreMission(
                        solveId = viewModel.solveId,
                        body = ScoreRequestModel(
                            SolveStatus.CORRECT_ANSWER
                        )
                    )
                }

                SolveStatus.WRONG_ANSWER -> {
                    viewModel.scoreMission(
                        solveId = viewModel.solveId,
                        body = ScoreRequestModel(
                            SolveStatus.WRONG_ANSWER
                        )
                    )
                }
            }
        },
        getDetailSolveMission = { viewModel.detailScoreMission(viewModel.solveId) },
        detailSolveMissionUiState = detailSolveMissionUiState,
    )
}

@Composable
private fun GradingAnswerScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    onNavigate: (String) -> Unit,
    onAnswer: () -> Unit,
    onWrongAnswer: () -> Unit,
    onSolveMission: () -> Unit,
    getDetailSolveMission: () -> Unit,
    detailSolveMissionUiState: DetailScoreMissionUiState,
) {
    val (selectedCorrect, setSelectedCorrect) = remember { mutableStateOf(false) }
    val (selectedIncorrect, setSelectedIncorrect) = remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        getDetailSolveMission()
    }

    StackKnowledgeAndroidTheme { colors, _ ->
        Box {
            Column(
                modifier = modifier
                    .background(color = colors.WHITE)
                    .fillMaxSize()
            ) {
                StackKnowledgeTopBar()

                Spacer(modifier = modifier.height(90.dp))

                if (detailSolveMissionUiState is DetailScoreMissionUiState.Success) {
                    val solveMission =
                        detailSolveMissionUiState.detailSolveMissionResponseModel

                    SolvedMissionTitle(
                        solveMissionTitle = solveMission.title,
                    )
                    SolvedMissionAnswer(
                        solveMissionSolution = solveMission.solution
                    )
                }

                GradingRadioButton(
                    isSelected = selectedCorrect,
                    onClick = {
                        setSelectedCorrect(!selectedCorrect)
                        setSelectedIncorrect(false)
                    },
                    onAnswer = onAnswer,
                    onWrongAnswer = onWrongAnswer,
                    onScoreMission = onSolveMission,
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