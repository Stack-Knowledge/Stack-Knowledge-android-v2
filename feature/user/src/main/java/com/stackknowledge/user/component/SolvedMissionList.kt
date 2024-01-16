package com.stackknowledge.user.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun SolvedMissionList(
    modifier: Modifier = Modifier,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Column(
            modifier = modifier
                .background(color = colors.WHITE)
                .fillMaxWidth()
        ) {

            Spacer(modifier = modifier.height(36.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(
                    horizontal = 16.dp,
                    vertical = 16.dp
                )
            ) {
                items(10) {
                    SolvedMissionItem()
                }
            }
        }
    }
}

@Preview
@Composable
fun SolvedMissionListPre() {
    SolvedMissionList()
}