package com.stackknowledge.score_mission

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.score_mission.component.GradingRadioButton
import com.stackknowledge.score_mission.component.SolvedMissionAnswer
import com.stackknowledge.score_mission.component.SolvedMissionTitle
import com.stackknowledge.score_mission.viewmodel.ScoreMissionViewModel
import com.stackknowledge.score_mission.viewmodel.uistate.DetailScoreMissionUiState
import enumdatatype.SolveStatus
import remote.request.user.ScoreRequestModel

@Composable
internal fun GradingAnswerRoute(
    viewModel: ScoreMissionViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
) {
    val detailSolveMissionUiState by viewModel.detailScoreMissionUiState.collectAsStateWithLifecycle()

    GradingAnswerScreen(
        onAnswer = {
            viewModel.scoreMission(
                viewModel.solveId,
                ScoreRequestModel(
                    SolveStatus.CORRECT_ANSWER
                )
            )
        },
        onWrongAnswer = {
            viewModel.scoreMission(
                viewModel.solveId,
                ScoreRequestModel(
                    SolveStatus.WRONG_ANSWER
                )
            )
        },
        getDetailSolveMission = { viewModel.detailScoreMission(viewModel.solveId) },
        detailSolveMissionUiState = detailSolveMissionUiState,
    )
}

@Composable
private fun GradingAnswerScreen(
    modifier: Modifier = Modifier,
    onAnswer: () -> Unit,
    onWrongAnswer: () -> Unit,
    getDetailSolveMission: () -> Unit,
    detailSolveMissionUiState: DetailScoreMissionUiState,
) {
    val (selectedCorrect, setSelectedCorrect) = remember { mutableStateOf(false) }
    val (selectedIncorrect, setSelectedIncorrect) = remember { mutableStateOf(false) }

    StackKnowledgeAndroidTheme { colors, typography ->
        Surface {
            Column(
                modifier = modifier
                    .background(color = colors.WHITE)
                    .fillMaxSize()
            ) {
                StackKnowledgeTopBar()

                Spacer(modifier = modifier.height(90.dp))

                if (detailSolveMissionUiState is DetailScoreMissionUiState.Success) {
                    val solveMissionTitle =
                        detailSolveMissionUiState.detailSolveMissionResponseModel

                    SolvedMissionTitle(
                        solveMissionTitle = solveMissionTitle.title,
                    )
                }

                if (detailSolveMissionUiState is DetailScoreMissionUiState.Success) {
                    val solveMissionSolution =
                        detailSolveMissionUiState.detailSolveMissionResponseModel
                    SolvedMissionAnswer(
                        solveMissionSolution = solveMissionSolution.solution
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
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun GradingAnswerScreenPre() {
//    GradingAnswerScreen()
//}