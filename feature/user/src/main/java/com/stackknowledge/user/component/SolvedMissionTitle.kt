package com.stackknowledge.user.component

import androidx.compose.foundation.background
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
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun SolvedMissionTitle(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Surface {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = colors.WHITE)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.mission),
                    style = typography.bodyLarge,
                    color = colors.BLACK,
                    modifier = modifier
                        .padding(bottom = 6.dp)
                )

                Text(
                    text = "북학파에 대한 배경을 적고 일이 일어난 순서를 알맞게 서술하시오.",
                    style = typography.bodyMedium,
                    color = colors.G2
                )

                Spacer(modifier = modifier.height(40.dp))
            }
        }
    }
}

@Preview
@Composable
fun SolvedMissionTitlePre() {
    SolvedMissionTitle()
}