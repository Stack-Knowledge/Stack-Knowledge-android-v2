package com.stackkowledge.mission

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackkowledge.mission.component.EntireMissionList

@Composable
fun EntireMissionScreen(
    modifier: Modifier = Modifier,
) {
    StackKnowledgeAndroidTheme { colors, _ ->
        Surface {
            Column(
                modifier = modifier
                    .background(color = colors.WHITE)
                    .fillMaxSize()
            ) {
                StackKnowledgeTopBar()
                EntireMissionList()
            }
        }
    }
}

@Preview
@Composable
fun EntireMissionScreenPre() {
    EntireMissionScreen()
}