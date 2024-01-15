package com.stackknowledge.ranking.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun RankingList(
    modifier: Modifier = Modifier,
) {
    val itemCount = 10
    
    StackKnowledgeAndroidTheme { colors, typography ->
        Column(
            modifier = modifier
                .background(color = colors.WHITE)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = stringResource(R.string.ranking),
                style = typography.headlineMedium,
                color = colors.BLACK
            )
            Spacer(modifier = modifier.height(19.dp))
            LazyColumn() {
                items(itemCount) { index ->
                    when(index) {
                        0 -> {
                            Box(
                                modifier = modifier
                                    .fillMaxWidth()
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.first_ranking_frame),
                                    contentDescription = "First Ranking Frame",
                                    modifier = modifier
                                        .fillMaxWidth()
                                        .height(54.dp),
                                    contentScale = ContentScale.FillBounds
                                )
                                Column(
                                    modifier = modifier.fillMaxWidth()
                                ) {
                                    RankingItem(
                                        rankingNum = "${index + 1}"
                                    )
                                    Spacer(modifier = modifier.height(5.dp))
                                    Spacer(
                                        modifier = modifier
                                            .height(1.dp)
                                            .fillMaxWidth()
                                            .background(color = colors.G1)
                                    )
                                }
                            }
                        }

                        else -> {
                            Column(
                                modifier = modifier.fillMaxWidth()
                            ) {
                                RankingItem(
                                    rankingNum = "${index + 1}"
                                )
                                Spacer(modifier = modifier.height(5.dp))
                                if(index < itemCount - 1) {
                                    Spacer(
                                        modifier = modifier
                                            .height(1.dp)
                                            .fillMaxWidth()
                                            .background(color = colors.G1)
                                    )
                                }
                            }
                        }
                    }
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