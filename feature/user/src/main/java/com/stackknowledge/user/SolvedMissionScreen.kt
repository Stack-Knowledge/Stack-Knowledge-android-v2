package com.stackknowledge.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun SolvedMissionScreen(
    modifier: Modifier = Modifier,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Surface {
            Column(
                modifier = modifier
                    .background(color = colors.WHITE)
                    .fillMaxSize()
            ) {
                StackKnowledgeTopBar()

            }
        }
    }
}

@Preview
@Composable
fun SolvedMissionScreenPre() {
    SolvedMissionScreen()
}