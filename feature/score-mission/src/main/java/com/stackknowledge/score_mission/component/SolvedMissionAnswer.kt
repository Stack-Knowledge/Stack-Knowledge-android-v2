package com.stackknowledge.score_mission.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun SolvedMissionAnswer(
    modifier: Modifier = Modifier,
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
                    text = stringResource(id = R.string.answer),
                    color = colors.BLACK,
                    style = typography.bodyLarge,
                    modifier = modifier.padding(bottom = 8.dp)
                )

                Box(
                    modifier = modifier
                        .clip(RoundedCornerShape(10.dp))
                        .wrapContentSize()
                        .background(color = colors.G5)
                ) {
                    Text(
                        modifier = modifier
                            .padding(
                                top = 12.dp,
                                start = 12.dp,
                                end = 12.dp,
                                bottom = 134.dp
                            )
                            .fillMaxWidth(),
                        text = "북학파에 대한 배경을 적고 일이 일어난 순서를 알맞게 서술하시오.",
                        style = typography.bodyMedium,
                        color = colors.BLACK
                    )
                }
                
                Spacer(modifier = modifier.height(9.dp))
            }
        }
    }
}

@Preview
@Composable
fun SolvedMissionAnswerPre() {
    SolvedMissionAnswer()
}