package com.stackknowledge.user.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun SolvedMissionItem(
    modifier: Modifier = Modifier,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Surface(
            modifier = modifier
                .clip(shape = RoundedCornerShape(20.dp))
                .background(
                    color = colors.WHITE,
                )
                .width(156.dp)
                .height(180.dp),
            shadowElevation = 8.dp
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = modifier.height(28.dp))

                Text(
                    text = "정영운",
                    color = colors.BLACK,
                    style = typography.bodyLarge
                )
                Spacer(modifier = modifier.height(16.dp))

                Text(
                    text = "여기에 한줄설명 적을거임",
                    color = colors.G2,
                    style = typography.displayMedium
                )

                Spacer(modifier = modifier.height(46.dp))

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
fun SolvedMissionItemPre(
    modifier: Modifier = Modifier,
) {
    SolvedMissionItem()
}