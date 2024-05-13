package com.stackkowledge.mission.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun EntireMissionList(
    modifier: Modifier = Modifier,
) {
    StackKnowledgeAndroidTheme { colors, _ ->
        Column(
            modifier = modifier
                .background(color = colors.WHITE)
                .fillMaxSize()
                .padding(bottom = 116.dp)
        ) {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colors.WHITE),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    top = 16.dp,
                ),
            ) {
                items(10) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        EntireMissionItem()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun EntireMissionListPre() {
    EntireMissionList()
}