package com.stackknowledge.score_mission.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import remote.request.user.ScoreRequestModel
import remote.response.user.GetSolveMissionListModel
import remote.response.user.GetSolveMissionResponseModel
import java.util.UUID

@Composable
fun SolvedMissionList(
    modifier: Modifier = Modifier,
    scoreMission: GetSolveMissionResponseModel,
    onClick: () -> Unit,
    intentId: (String) -> Unit,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Column(
            modifier = modifier
                .background(color = colors.WHITE)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(bottom = 116.dp)
        ) {
            LazyVerticalGrid(
                modifier = modifier.fillMaxSize(),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    top = 16.dp,
                ),
            ) {
                itemsIndexed(scoreMission.response) {_, item ->
                    Box {
                        SolvedMissionItem(
                            name = item.user.name,
                            title = item.title,
                            point = item.point,
                            onClick = { onClick() },
                            intentId = { intentId(item.solveId) }
                        )
                    }
                }
            }
        }
    }
}