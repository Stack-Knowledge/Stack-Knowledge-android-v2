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
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.textfield.InputTitleTextField
import com.stackknowledge.design_system.component.textfield.StackKnowledgeTextField
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun InputTitle(
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
                    text = stringResource(R.string.notice_resolve_mission_time),
                    style = typography.bodySmall,
                    color = colors.G2,
                    modifier = modifier.padding(horizontal = 53.dp)
                )

                Spacer(modifier = modifier.height(18.dp))

                Text(
                    text = "제목",
                    color = colors.BLACK,
                    style = typography.bodyLarge,
                    modifier = modifier.padding(bottom = 8.dp)
                )

                InputTitleTextField(
                    modifier = modifier.fillMaxWidth()
                )

                Spacer(modifier = modifier.height(28.dp))

            }
        }
    }
}

@Preview
@Composable
fun InputTitlePre() {
    InputTitle()
}