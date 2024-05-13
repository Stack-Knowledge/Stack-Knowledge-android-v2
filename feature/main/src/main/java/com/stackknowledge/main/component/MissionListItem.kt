package com.stackknowledge.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun MissionListItem(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Box(
            modifier = modifier
                .width(116.dp)
                .height(158.dp)
                .background(
                    color = colors.WHITE,
                    shape = RoundedCornerShape(20.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "미소쌤",
                    style = typography.bodyMedium,
                    color = colors.BLACK
                )
                Spacer(modifier = modifier.height(12.dp))
                Text(
                    text = "북학파의 배경",
                    style = typography.bodySmall,
                    color = colors.G2
                )
                Spacer(modifier = modifier.height(48.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "1000",
                        style = typography.bodyMedium,
                        color = colors.BLACK
                    )
                    Spacer(modifier = modifier.width(2.dp))
                    Text(
                        text = stringResource(R.string.mileage),
                        style = typography.bodySmall,
                        color = colors.BLACK
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MissionListItemPre() {
    MissionListItem()
}
