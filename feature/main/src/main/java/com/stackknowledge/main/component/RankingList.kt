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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun RankingList(
    modifier: Modifier = Modifier
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
                LazyRow(
                    modifier = modifier.padding(12.dp)
                ) {
                    items(10) { index ->
                        when(index) {
                            0 -> {
                                Box {
                                    Box(
                                        modifier = modifier.padding(4.dp)
                                    ) {
                                        RankingListItem()
                                    }
                                    RankingNumFirst()
                                }
                            }

                            1 -> {
                                Box {
                                    Box(
                                        modifier = modifier.padding(4.dp)
                                    ) {
                                        RankingListItem()
                                    }
                                    RankingNumSecond()
                                }
                            }

                            2 -> {
                                Box {
                                    Box(
                                        modifier = modifier.padding(4.dp)
                                    ) {
                                        RankingListItem()
                                    }
                                    RankingNumThird()
                                }
                            }

                            else -> {
                                Box(
                                    modifier = modifier.padding(4.dp)
                                ) {
                                    RankingListItem()
                                }
                            }
                        }
                        Spacer(modifier = modifier.width(16.dp))
                    }
                }
                Column(
                    modifier = modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    JoinWaitingButton(
                        modifier = modifier
                            .padding(top = 80.dp, end = 2.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun RankingListPre() {
    RankingList()
}