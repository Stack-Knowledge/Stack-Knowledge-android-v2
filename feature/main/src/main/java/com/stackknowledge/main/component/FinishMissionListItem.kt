package com.stackknowledge.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun FinishMissionListItem(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Box(
            modifier = modifier
                .width(116.dp)
                .height(158.dp)
                .background(
                    color = colors.G3,
                    shape = RoundedCornerShape(20.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.time_over),
                    style = typography.bodyMedium,
                    color = colors.WHITE
                )
                Spacer(modifier = modifier.height(40.dp))
                Text(
                    text = stringResource(R.string.mission_time_over),
                    style = typography.bodySmall,
                    color = colors.WHITE,
                    textAlign = TextAlign.Center,
                    modifier = modifier.padding(start = 6.dp, end = 6.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun FinishMissionListItemPre() {
    FinishMissionListItem()
}