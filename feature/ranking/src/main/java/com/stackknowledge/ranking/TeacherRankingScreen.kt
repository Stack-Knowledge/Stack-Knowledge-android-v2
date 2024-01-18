package com.stackknowledge.ranking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.ranking.component.RankingList

@Composable
fun TeacherRankingScreen(
    modifier: Modifier = Modifier,
) {
    StackKnowledgeAndroidTheme { colors, _ ->
        Surface {
            Column(
                modifier = modifier
                    .background(color = colors.WHITE)
                    .fillMaxSize()
            ) {
                StackKnowledgeTopBar()

                Spacer(modifier = modifier.height(36.dp))

                RankingList()
            }
        }
    }
}

@Preview
@Composable
fun TeacherRankingScreenPre() {
    TeacherRankingScreen()
}