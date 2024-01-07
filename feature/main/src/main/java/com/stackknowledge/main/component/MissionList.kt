package com.stackknowledge.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun MissionList(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.mission),
                style = typography.bodyLarge,
                color = colors.BLACK
            )
            Spacer(modifier = modifier.height(8.dp))
            Box(
                modifier = modifier
                    .height(190.dp)
                    .background(
                        color = colors.G1,
                        shape = RoundedCornerShape(20.dp)
                    )
            ) {
                LazyRow(
                    modifier = modifier.padding(16.dp)
                ) {
                    items(10) {
                        MissionListItem()
                        Spacer(modifier = modifier.width(16.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MissionListPre() {
    MissionList()
}