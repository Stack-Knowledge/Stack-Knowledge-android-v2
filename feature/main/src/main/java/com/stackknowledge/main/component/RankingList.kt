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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.main.viewModel.uistate.GetMissionUiState
import com.stackknowledge.main.viewModel.uistate.GetRankingUiState
import enumdatatype.Authority

@Composable
fun RankingList(
    modifier: Modifier = Modifier,
    getRankingUiState: GetRankingUiState,
) {
    StackKnowledgeAndroidTheme { colors, _ ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Box(
                modifier = modifier
                    .height(190.dp)
                    .background(
                        color = colors.G1,
                        shape = RoundedCornerShape(20.dp)
                    )
            ) {
                when (getRankingUiState) {
                    is GetRankingUiState.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "로딩중.."
                            )
                        }
                    }
                    is GetRankingUiState.Success -> {
                        val list = getRankingUiState.getItemResponseModel
                        LazyRow(
                            modifier = modifier.padding(12.dp)
                        ) {
                            val rankingNumbers = listOf<@Composable () -> Unit>(
                                { RankingNumFirst() },
                                { RankingNumSecond() },
                                { RankingNumThird() }
                            )

                            items(list.size) { index ->
                                Box {
                                    Box(modifier = modifier.padding(4.dp)) {
                                        RankingListItem()
                                    }
                                    if (index < 3) {
                                        rankingNumbers[index]()
                                    }
                                }
                                Spacer(modifier = modifier.width(16.dp))
                            }
                        }
                    }
                    is GetRankingUiState.Error -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "랭킹이 비었어요! \n1등에 도전 해 봐요!"
                            )
                        }
                    }
                }
            }
        }
    }
}