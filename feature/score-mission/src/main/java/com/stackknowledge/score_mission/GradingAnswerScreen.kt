package com.stackknowledge.score_mission

import android.util.Log
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.common.util.Event
import com.minstone.ui.navigation.StackKnowledgeBottomNavigation
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.dialog.StackKnowledgeDialog
import com.stackknowledge.design_system.component.toast.SuccessToastMessage
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.score_mission.component.GradingRadioButton
import com.stackknowledge.score_mission.component.SolvedMissionAnswer
import com.stackknowledge.score_mission.component.SolvedMissionTitle
import com.stackknowledge.score_mission.viewmodel.ScoreMissionViewModel
import com.stackknowledge.score_mission.viewmodel.uistate.DetailScoreMissionUiState
import com.stackknowledge.score_mission.viewmodel.uistate.ScoreMissionUiState
import enumdatatype.Authority
import remote.request.user.ScoreRequestModel

@Composable
internal fun GradingAnswerRoute(
    viewModel: ScoreMissionViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    onNavigate: (Authority, String) -> Unit,
    scoreMissionSuccess: () -> Unit,
) {
    var role by remember { mutableStateOf(Authority.ROLE_TEACHER) } //로그인 로직 적용후 변경
    val detailSolveMissionUiState by viewModel.detailScoreMissionUiState.collectAsStateWithLifecycle()
    val scoreMissionUiState by viewModel.scoreMissionUiState.collectAsStateWithLifecycle()

    GradingAnswerScreen(
        role = role,
        solveId = viewModel.solveId.value,
        onNavigate = { navType -> onNavigate(role, navType) },
        onAnswer = { viewModel.onSolveStatus(it) },
        onWrongAnswer = { viewModel.onSolveStatus(it) },
        onSolveMission = {
            viewModel.scoreMission(
                solveId = viewModel.solveId.value,
                body = ScoreRequestModel(viewModel.solveStatus.value)
            )
        },
        getDetailSolveMission = viewModel::detailScoreMission,
        detailSolveMissionUiState = detailSolveMissionUiState,
        scoreMissionUiState = scoreMissionUiState,
        onSuccess = scoreMissionSuccess,
    )
}

@Composable
private fun GradingAnswerScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    solveId: String,
    onNavigate: (String) -> Unit,
    onAnswer: (String) -> Unit,
    onWrongAnswer: (String) -> Unit,
    onSolveMission: () -> Unit,
    getDetailSolveMission: (String) -> Unit,
    detailSolveMissionUiState: DetailScoreMissionUiState,
    scoreMissionUiState: Event<Nothing>,
    onSuccess: () -> Unit,
) {
    val context = LocalContext.current
    val (selectedCorrect, setSelectedCorrect) = remember { mutableStateOf(false) }
    val (selectedIncorrect, setSelectedIncorrect) = remember { mutableStateOf(false) }
    var openDialog by remember { mutableStateOf(false) }
    var successScoreMissionToast by remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        getDetailSolveMission(solveId)
    }

    if (openDialog) {
        StackKnowledgeDialog(
            content = stringResource(id = com.stackknowledge.design_system.R.string.finish_score_mission),
            onConfirm = {
                onSolveMission()
                openDialog = false
            },
            onDismiss = { openDialog = false },
            openDialog = openDialog,
            onStateChange = { openDialog = it },
        )
    }

    if (scoreMissionUiState is Event.Success) {
        successScoreMissionToast = true
        onSuccess()
    }

    if (successScoreMissionToast) {
        val toastMessage = SuccessToastMessage(context)
        toastMessage.MakeText(message = stringResource(id = R.string.success_score_mission))
        successScoreMissionToast = false
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
                    onAnswer = { onAnswer("CORRECT_ANSWER") },
                    onWrongAnswer = { onWrongAnswer("WRONG_ANSWER") },
                    openDialog = { openDialog = true },
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