package com.stackknowledge.resolve_mission

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.resolve_mission.component.InputAnswer
import com.stackknowledge.resolve_mission.component.Mission
import com.stackknowledge.resolve_mission.component.MissionTimer

@Composable
fun ResolveMissionScreen(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->
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

                    MissionTimer()

                    Spacer(modifier = modifier.weight(1f))
                }
                Spacer(modifier = modifier.height(45.dp))
                
                Mission()
                InputAnswer()
            }
        }
    }
}

@Preview
@Composable
fun ResolveMissionScreenPre() {
    ResolveMissionScreen()
}