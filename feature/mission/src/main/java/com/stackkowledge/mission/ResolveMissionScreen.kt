package com.stackkowledge.mission

import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.common.toast.makeToast
import com.minstone.ui.navigation.StackKnowledgeBottomNavigation
import com.stackknowledge.design_system.component.dialog.StackKnowledgeDialog
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import enumdatatype.Authority
import com.stackknowledge.design_system.R
import com.stackkowledge.mission.component.InputAnswer
import com.stackkowledge.mission.component.Mission
import com.stackkowledge.mission.component.MissionTimer
import com.stackkowledge.mission.viewmodel.MissionViewModel
import com.stackkowledge.mission.viewmodel.uistate.DetailMissionUiState
import kotlinx.coroutines.delay
import remote.request.solve.SolveRequestModel

@Composable
internal fun ResolveMissionRoute(
    onNavigate: (Authority, String) -> Unit,
    viewModel: MissionViewModel = hiltViewModel(LocalContext.current as ComponentActivity)
) {
    var role by remember { mutableStateOf(Authority.ROLE_STUDENT) } //로그인 로직 적용후 변경
    val detailMissionUiState by viewModel.detailMissionUiState.collectAsStateWithLifecycle()

    ResolveMissionScreen(
        role = role,
        missionId = viewModel.missionId.value,
        answer = viewModel.answer.value,
        onAnswer = { viewModel.onAnswer(it) },
        onNavigate = { navType -> onNavigate(role, navType) },
        getSolveMission = viewModel::detailMission,
        submit = {
            viewModel.solveMission(
                missionId = viewModel.missionId.value,
                SolveRequestModel(
                    solution = viewModel.answer.value
                )
            )
        },
        detailMissionUiState = detailMissionUiState
    )
}

@Composable
private fun ResolveMissionScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    missionId: String,
    answer: String,
    onAnswer: (String) -> Unit,
    onNavigate: (String) -> Unit,
    getSolveMission: (String) -> Unit,
    submit: () -> Unit,
    detailMissionUiState: DetailMissionUiState,
) {
    val context = LocalContext.current
    var openDialog by remember { mutableStateOf(false) }
    var finishTimeDialog by remember { mutableStateOf(false) }
    var autoSubmitDialog by remember { mutableStateOf(false) }
    var notNavigate by remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        getSolveMission(missionId)
    }

    BackHandler(enabled = !autoSubmitDialog && !notNavigate) {
        autoSubmitDialog = true
    }

    if (openDialog) {
        StackKnowledgeDialog(
            content = stringResource(id = R.string.submit_mission),
            onConfirm = {
                submit()
                openDialog = false
            },
            onDismiss = { openDialog = false },
            openDialog = openDialog,
            onStateChange = { openDialog = it }
        )
    }

    if (finishTimeDialog) {
        StackKnowledgeDialog(
            content = stringResource(id = R.string.finish_time_of_submit_mission),
            onConfirm = {
                finishTimeDialog = false
            },
            onDismiss = {
                makeToast(context, "취소 해도 문제가 자동으로 제출됩니다.")
            },
            openDialog = finishTimeDialog,
            onStateChange = { finishTimeDialog = it }
        )
    }

    if (autoSubmitDialog) {
        StackKnowledgeDialog(
            content = stringResource(id = R.string.auto_submit_mission),
            onConfirm = {
                submit()
                autoSubmitDialog = false
                notNavigate = false
            },
            onDismiss = {
                autoSubmitDialog = false
                notNavigate = true
            },
            openDialog = autoSubmitDialog,
            onStateChange = {
                autoSubmitDialog = it
            }
        )
    }

    StackKnowledgeAndroidTheme { colors, typography ->
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .background(color = colors.WHITE)
            ) {
                StackKnowledgeTopBar()
                Spacer(modifier = modifier.height(28.dp))

                if (detailMissionUiState is DetailMissionUiState.Success) {
                    val mission = detailMissionUiState.body
                    var timeLimit by remember { mutableIntStateOf(mission.timeLimit) }
                    var minute by remember { mutableIntStateOf(timeLimit / 60) }
                    var second by remember { mutableIntStateOf(timeLimit % 60) }

                    LaunchedEffect(timeLimit) {
                        if (timeLimit > 0) {
                            delay(1000L)
                            timeLimit--
                            minute = timeLimit / 60
                            second = timeLimit % 60
                        } else {
                            submit()
                            finishTimeDialog = true
                        }
                    }

                    Row {
                        Spacer(modifier = modifier.weight(1f))

                        MissionTimer(
                            minute = minute.toString().padStart(2, '0'),
                            second = second.toString().padStart(2, '0'),
                        )

                        Spacer(modifier = modifier.weight(1f))
                    }
                    Spacer(modifier = modifier.height(45.dp))


                    Mission(missionContent = mission.content)
                }

                InputAnswer(
                    answer = answer,
                    onAnswerValueChange = { onAnswer(it) },
                    openDialog = { openDialog = true }
                )
            }
            Box(
                modifier = Modifier.align(alignment = Alignment.BottomCenter),
            ) {
                StackKnowledgeBottomNavigation(
                    modifier = Modifier,
                    role = role
                ) {
                    if (!autoSubmitDialog && !notNavigate) {
                        onNavigate(it)
                    }
                    autoSubmitDialog = true
                }
            }
        }
    }
}