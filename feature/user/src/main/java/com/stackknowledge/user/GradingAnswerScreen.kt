package com.stackknowledge.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.component.button.StackKnowledgeButton
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.user.component.GradingRadioButton
import com.stackknowledge.user.component.SolvedMissionAnswer
import com.stackknowledge.user.component.SolvedMissionTitle
import com.stackknowledge.design_system.R

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