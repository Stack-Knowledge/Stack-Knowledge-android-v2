package com.stackknowledge.main.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StackKnowledgePager(
    modifier: Modifier = Modifier
) {
    val initialPage = Int.MAX_VALUE / 2 - 3
    val pagerState = rememberPagerState(
        pageCount = { Int.MAX_VALUE },
        initialPage = initialPage
    )

    LaunchedEffect(key1 = pagerState.currentPage) {
        launch {
            while (true) {
                delay(2000)
                withContext(NonCancellable) {
                    if (pagerState.currentPage + 1 in 0..Int.MAX_VALUE) {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            }
        }
    }

    StackKnowledgeAndroidTheme { colors, typography ->
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Box(
                contentAlignment = Alignment.BottomCenter
            ) {
                HorizontalPager(
                    state = pagerState
                ) { page ->

                    when (page % 3) {
                        0 -> {
                            Image(
                                painter = painterResource(R.drawable.first_banner),
                                contentDescription = "First Banner",
                                modifier = modifier.fillMaxWidth(),
                                contentScale = ContentScale.FillBounds
                            )
                        }

                        1 -> {
                            Image(
                                painter = painterResource(R.drawable.second_banner),
                                contentDescription = "Second Banner",
                                modifier = modifier.fillMaxWidth(),
                                contentScale = ContentScale.FillBounds
                            )
                        }

                        2 -> {
                            Image(
                                painter = painterResource(R.drawable.third_banner),
                                contentDescription = "Third Banner",
                                modifier = modifier.fillMaxWidth(),
                                contentScale = ContentScale.FillBounds
                            )
                        }
                    }
                }
                Column(
                    modifier = modifier.padding(bottom = 12.dp)
                ) {
                    PagerIndicator(
                        count = 3,
                        currentPage = pagerState.currentPage % 3,
                    )
                }
            }
            Spacer(modifier = modifier.height(8.dp))
            Text(
                text = stringResource(R.string.notice_resolve_mission_time),
                style = typography.bodySmall,
                color = colors.G2,
                modifier = modifier.padding(start = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun StackKnowledgePagerPre() {
    StackKnowledgePager()
}
