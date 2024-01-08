package com.stackkowledge.mission

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackkowledge.mission.component.CreateMissionTimer
import com.stackkowledge.mission.component.InputTitle

@Composable
fun CreateMissionScreen(
    modifier: Modifier = Modifier,
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

                    CreateMissionTimer()

                    Spacer(modifier = modifier.weight(1f))
                }

                InputTitle()
                
            }
        }
    }
}

@Preview
@Composable
fun CreateMissionScreenPre() {
    CreateMissionScreen()
}