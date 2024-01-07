package com.stackknowledge.main.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    count: Int,
    currentPage: Int
) {
    StackKnowledgeAndroidTheme { colors, _ ->
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            (0 until count).forEach {
                Canvas(
                    modifier = modifier
                        .width(4.dp)
                        .height(4.dp)
                ) {
                    drawCircle(
                        color = if (it == currentPage) colors.BLACK else colors.WHITE
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PagerIndicatorPre() {
    PagerIndicator(
        count = 3,
        currentPage = 1
    )
}