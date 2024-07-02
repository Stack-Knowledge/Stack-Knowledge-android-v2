package com.stackkowledge.mission

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackkowledge.mission.component.CreateMissionTimer
import com.stackkowledge.mission.component.InputMission
import com.stackkowledge.mission.component.InputTitle
import com.stackkowledge.mission.util.isValidNumber
import com.stackkowledge.mission.viewmodel.MissionViewModel
import remote.request.mission.CreateMissionRequestModel

@Composable
internal fun CreateMissionRoute() {
    CreateMissionScreen()
}

@Composable
private fun CreateMissionScreen(
    modifier: Modifier = Modifier,
    viewModel: MissionViewModel = hiltViewModel(),
) {
    val context = LocalContext.current

    StackKnowledgeAndroidTheme { colors, _ ->
        Surface(
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
                                Toast.makeText(context, "숫자를 입력 해 주세요.", Toast.LENGTH_SHORT).show()
                            }
                        },
                        onSecondValueChange = {
                            if (it.isValidNumber()) {
                                val number = it.toInt()
                                viewModel.onSecond(number)
                            } else {
                                Toast.makeText(context, "숫자를 입력 해 주세요.", Toast.LENGTH_SHORT).show()
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
                        viewModel.createMission(
                            CreateMissionRequestModel(
                                viewModel.title.value,
                                viewModel.content.value,
                                viewModel.timeLimit.intValue,
                            )
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun CreateMissionScreenPre() {
    CreateMissionScreen()
}