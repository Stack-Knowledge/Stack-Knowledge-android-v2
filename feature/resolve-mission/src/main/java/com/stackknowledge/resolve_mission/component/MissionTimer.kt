package com.stackknowledge.resolve_mission.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun MissionTimer(
    modifier: Modifier = Modifier
) {
    var minute by remember { mutableStateOf("13") }
    var second by remember { mutableStateOf("00") }

    StackKnowledgeAndroidTheme { colors, typography ->
        Box(
            modifier = modifier
                .wrapContentSize()
                .background(
                    color = colors.WHITE,
                ),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = modifier
                    .width(170.dp)
                    .height(170.dp),
                color = colors.P1
            )
            Text(
                text = "$minute : $second",
                style = typography.headlineLarge,
                color = colors.BLACK
            )
        }
    }
}

@Preview
@Composable
fun MissionTimerPre() {
    MissionTimer()
}