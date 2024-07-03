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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.minstone.ui.navigation.StackKnowledgeBottomNavigation
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.dialog.StackKnowledgeDialog
import com.stackknowledge.design_system.component.dialog.SubmitDialog
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackkowledge.mission.component.CreateMissionTimer
import com.stackkowledge.mission.component.InputMission
import com.stackkowledge.mission.component.InputTitle
import com.stackkowledge.mission.uistate.CreateMissionUiState
import com.stackkowledge.mission.util.isValidNumber
import com.stackkowledge.mission.viewmodel.MissionViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import remote.request.mission.CreateMissionRequestModel
import enumdatatype.Authority

@Composable
internal fun CreateMissionRoute(
    onNavigate: (Authority, String) -> Unit,
) {
    var role by remember { mutableStateOf(Authority.ROLE_TEACHER) } //로그인 로직 적용후 변경
    CreateMissionScreen(
        role = role,
        onNavigate = { navType -> onNavigate(role, navType) }
    )
}

@Composable
private fun CreateMissionScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    onNavigate: (String) -> Unit,
    viewModel: MissionViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val uiState by viewModel.createMissionUiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    var createMissionDialog by remember { mutableStateOf(false) }
    var cancelCreateMissionDialog by remember { mutableStateOf(false) }
    var successCreateMissionDialog by remember { mutableStateOf(false) }

    if (createMissionDialog) {
        StackKnowledgeDialog(
            content = stringResource(id = R.string.select_create_mission),
            onConfirm = {
                viewModel.createMission(
                    CreateMissionRequestModel(
                        viewModel.title.value,
                        viewModel.content.value,
                        viewModel.timeLimit.intValue,
                    )
                )
                createMissionDialog = false
                Log.e("CreateMissionScreen", "Ui State : $uiState")
            },
            onDismiss = {
                createMissionDialog = false
                cancelCreateMissionDialog = true
            },
        )
    }
    if (cancelCreateMissionDialog) {
        StackKnowledgeDialog(
            content = stringResource(id = R.string.cancel_select_create_mission),
            onConfirm = {
                viewModel.title.value = ""
                viewModel.content.value = ""
                viewModel.minute.intValue = 0
                viewModel.second.intValue = 0
                viewModel.timeLimit.intValue = 0
            },
            onDismiss = { cancelCreateMissionDialog = false }
        )
    }

    if (uiState is CreateMissionUiState.Success) {
//        LaunchedEffect(uiState is CreateMissionUiState.Success) {
//            delay(2000)
//            successCreateMissionDialog = true
//        }
        SubmitDialog(
            content = stringResource(id = R.string.success_create_mission),
            onDismiss = {
                coroutineScope.launch {
                    successCreateMissionDialog = true
                    delay(2000)
                    successCreateMissionDialog = false
                }
            }
        )
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
                        onMinute = viewModel.minute.intValue,
                        onSecond = viewModel.second.intValue,
                        onMinuteValueChange = {
                            if (it.isValidNumber()) {
                                val number = it.toInt()
                                viewModel.onMinute(number)
                            } else {
                                Toast.makeText(context, "숫자를 입력 해 주세요.", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        },
                        onSecondValueChange = {
                            if (it.isValidNumber()) {
                                val number = it.toInt()
                                viewModel.onSecond(number)
                            } else {
                                Toast.makeText(context, "숫자를 입력 해 주세요.", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    )

                    Spacer(modifier = modifier.weight(1f))
                }

                InputTitle(
                    title = viewModel.title.value,
                    onTitleValueChange = { viewModel.onTitle(it) },
                )

                InputMission(
                    content = viewModel.content.value,
                    onContentValueChange = { viewModel.onContent(it) },
                    onClick = {
                        viewModel.onTimeLimit()
                        createMissionDialog = true
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

