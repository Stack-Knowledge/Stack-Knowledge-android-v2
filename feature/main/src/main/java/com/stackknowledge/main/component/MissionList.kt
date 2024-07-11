package com.stackknowledge.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.CreationExtras
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.main.viewModel.uistate.GetMissionUiState
import remote.response.mission.MissionResponseModel

@Composable
fun MissionList(
    modifier: Modifier = Modifier,
    getMissionUiState: GetMissionUiState,
    onClick: (Int) -> Unit,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.solve_mission),
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
                when (getMissionUiState) {
                    is GetMissionUiState.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "로딩중.."
                            )
                        }
                    }

                    is GetMissionUiState.Success -> {
                        val list = getMissionUiState.getItemResponseModel
                        LazyRow(
                            modifier = modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            items(list.size) {index ->
                                MissionListItem(
                                    teacherName = list[index].user.name,
                                    title = list[index].title,
                                    point = list[index].point.toString(),
                                    onClick = { onClick(index) },
                                )
                                Spacer(modifier = modifier.width(16.dp))
                            }
                        }
                    }

                    is GetMissionUiState.Error -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "문제가 없나봐요.."
                            )
                        }
                    }
                }
            }
        }
    }
}