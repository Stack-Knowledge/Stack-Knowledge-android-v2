package com.stackkowledge.mission

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.example.common.util.Event
import com.minstone.ui.navigation.StackKnowledgeBottomNavigation
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.dialog.StackKnowledgeDialog
import com.stackknowledge.design_system.component.toast.SuccessToastMessage
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackkowledge.mission.component.CreateMissionTimer
import com.stackkowledge.mission.component.InputMission
import com.stackkowledge.mission.component.InputTitle
import com.stackkowledge.mission.util.isValidNumber
import com.stackkowledge.mission.viewmodel.MissionViewModel
import enumdata.Authority
import remote.request.mission.CreateMissionRequestModel

@Composable
internal fun CreateMissionRoute(
    viewModel: MissionViewModel = hiltViewModel(),
    onNavigate: (Authority, String) -> Unit,
    createMissionSuccess: () -> Unit,
) {
    var role by remember { mutableStateOf(Authority.ROLE_TEACHER) } //로그인 로직 적용후 변경
    val createMissionUiState by viewModel.createMissionUiState.collectAsStateWithLifecycle()

    CreateMissionScreen(
        role = role,
        onNavigate = { navType -> onNavigate(role, navType) },
        createMissionUiState = createMissionUiState,
        createMission = { viewModel.createMission(it) },
        title = viewModel.title.value,
        content = viewModel.content.value,
        minute = viewModel.minute.intValue,
        second = viewModel.second.intValue,
        timeLimit = viewModel.timeLimit.intValue,
        onTitle = { viewModel.onTitle(it) },
        onContent = { viewModel.onContent(it) },
        onMinute = { viewModel.onMinute(it) },
        onSecond = { viewModel.onSecond(it) },
        onTimeLimit = { viewModel.onTimeLimit() },
        resetTitle = { viewModel.title.value = it },
        resetContent = { viewModel.content.value = it },
        resetMinute = { viewModel.minute.intValue = it },
        resetSecond = { viewModel.second.intValue = it },
        resetTimeLimit = { viewModel.timeLimit.intValue = it },
        onSuccess = createMissionSuccess
    )
}

@Composable
private fun CreateMissionScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    onNavigate: (String) -> Unit,
    createMissionUiState: Event<Nothing>,
    createMission: (CreateMissionRequestModel) -> Unit,
    title: String,
    content: String,
    minute: Int,
    second: Int,
    timeLimit: Int,
    onTitle: (String) -> Unit,
    onContent: (String) -> Unit,
    onMinute: (Int) -> Unit,
    onSecond: (Int) -> Unit,
    onTimeLimit: () -> Unit,
    resetTitle: (String) -> Unit,
    resetContent: (String) -> Unit,
    resetMinute: (Int) -> Unit,
    resetSecond: (Int) -> Unit,
    resetTimeLimit: (Int) -> Unit,
    onSuccess: () -> Unit,
) {
    val context = LocalContext.current
    var createMissionOpenDialog by remember { mutableStateOf(false) }
    var cancelCreateMissionOpenDialog by remember { mutableStateOf(false) }
    var successCreateMissionToast by remember { mutableStateOf(false) }

    if (createMissionOpenDialog) {
        StackKnowledgeDialog(
            content = stringResource(id = R.string.select_create_mission),
            openDialog = createMissionOpenDialog,
            onStateChange = { createMissionOpenDialog = it },
            onConfirm = {
                createMission(
                    CreateMissionRequestModel(
                        title,
                        content,
                        timeLimit,
                    )
                )
                createMissionOpenDialog = false
            },
            onDismiss = {
                createMissionOpenDialog = false
                cancelCreateMissionOpenDialog = true
            },
        )
    }
    if (cancelCreateMissionOpenDialog) {
        StackKnowledgeDialog(
            content = stringResource(id = R.string.cancel_select_create_mission),
            openDialog = cancelCreateMissionOpenDialog,
            onStateChange = { cancelCreateMissionOpenDialog = it },
            onConfirm = {
                resetTitle("")
                resetContent("")
                resetMinute(0)
                resetSecond(0)
                resetTimeLimit(0)
                cancelCreateMissionOpenDialog = false
            },
            onDismiss = { cancelCreateMissionOpenDialog = false }
        )
    }

    if (createMissionUiState is Event.Success) {
        successCreateMissionToast = true
        onSuccess()
    }

    if (successCreateMissionToast) {
        val toastMessage = SuccessToastMessage(context)
        toastMessage.MakeText(message = stringResource(id = R.string.success_create_mission))
        successCreateMissionToast = false
    }

    StackKnowledgeAndroidTheme { colors, _ ->
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

                Row {
                    Spacer(modifier = modifier.weight(1f))

                    CreateMissionTimer(
                        minute = minute,
                        second = second,
                        onMinuteValueChange = {
                            if (it.isValidNumber()) {
                                val number = it.toInt()
                                onMinute(number)
                            } else {
                                makeToast(context, "숫자를 입력 해 주세요.")
                            }
                        },
                        onSecondValueChange = {
                            if (it.isValidNumber()) {
                                val number = it.toInt()
                                onSecond(number)
                            } else {
                                makeToast(context, "숫자를 입력 해 주세요.")
                            }
                        }
                    )

                    Spacer(modifier = modifier.weight(1f))
                }

                InputTitle(
                    title = title,
                    onTitleValueChange = { onTitle(it) },
                )

                InputMission(
                    content = content,
                    onContentValueChange = { onContent(it) },
                    onClick = {
                        onTimeLimit()
                        createMissionOpenDialog = true
                    }
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

