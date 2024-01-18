package com.stackknowledge.score_mission

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.score_mission.component.GradingRadioButton
import com.stackknowledge.score_mission.component.SolvedMissionAnswer
import com.stackknowledge.score_mission.component.SolvedMissionTitle

@Composable
fun GradingAnswerScreen(
    modifier: Modifier = Modifier,
) {
    val (selectedCorrect, setSelectedCorrect) = remember { mutableStateOf(false) }
    val (selectedIncorrect, setSelectedIncorrect) = remember { mutableStateOf(false) }

    StackKnowledgeAndroidTheme { colors, typography ->
        Surface {
            Column(
                modifier = modifier
                    .background(color = colors.WHITE)
                    .fillMaxSize()
            ) {
                StackKnowledgeTopBar()

                Spacer(modifier = modifier.height(90.dp))

                SolvedMissionTitle()

                SolvedMissionAnswer()

                GradingRadioButton(
                    isSelected = selectedCorrect,
                    onClick = {
                        setSelectedCorrect(!selectedCorrect)
                        setSelectedIncorrect(false)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun GradingAnswerScreenPre() {
    GradingAnswerScreen()
}