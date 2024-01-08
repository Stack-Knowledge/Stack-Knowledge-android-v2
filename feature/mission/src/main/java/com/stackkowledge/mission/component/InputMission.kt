package com.stackkowledge.mission.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.button.StackKnowledgeButton
import com.stackknowledge.design_system.component.textfield.StackKnowledgeTextField

@Composable
fun InputMission(
    modifier: Modifier = Modifier,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Surface {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.mission),
                    color = colors.BLACK,
                    style = typography.bodyLarge,
                    modifier = modifier.padding(bottom = 8.dp)
                )

                StackKnowledgeTextField(
                    placeholder = "문제를 작성해 주시기 바랍니다.",
                    modifier = modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .padding(bottom = 32.dp),
                    onValueChange = {}
                )

                StackKnowledgeButton(
                    text = stringResource(id = R.string.submit),
                    modifier = modifier
                        .height(60.dp)
                )

                Spacer(modifier.height(28.dp))
            }
        }
    }
}

@Preview
@Composable
fun InputMissionPre() {
    InputMission()
}