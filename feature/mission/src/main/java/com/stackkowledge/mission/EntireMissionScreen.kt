package com.stackkowledge.mission

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.common.util.Event
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.usecase.misson.GetMissionUseCase
import com.stackkowledge.mission.component.EntireMissionList
import com.stackkowledge.mission.uistate.GetMissionUiState
import com.stackkowledge.mission.viewmodel.MissionViewModel

@Composable
fun EntireMissionScreen(
    modifier: Modifier = Modifier,
    viewModel: MissionViewModel = hiltViewModel(),
) {
    val uiState by viewModel.missionUiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getMission()
    }

    Log.e("EntireMissionScreen", "UI State: $uiState")

    if (uiState is GetMissionUiState.Success) {
        val mission = (uiState as GetMissionUiState.Success).missionResponseModel

        StackKnowledgeAndroidTheme { colors, _ ->
            Surface {
                Column(
                    modifier = modifier
                        .background(color = colors.WHITE)
                        .fillMaxSize()
                ) {
                    StackKnowledgeTopBar()
                    EntireMissionList(
                        missionList = mission
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun EntireMissionScreenPre() {
    EntireMissionScreen()
}