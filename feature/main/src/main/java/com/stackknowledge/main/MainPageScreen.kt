package com.stackknowledge.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.component.topbar.LogoutTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.main.component.MissionList
import com.stackknowledge.main.component.RankingList
import com.stackknowledge.main.component.StackKnowledgePager

@Composable
fun MainPageScreen(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    StackKnowledgeAndroidTheme { colors, _ ->
        Surface(
            modifier = modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .verticalScroll(scrollState)
                    .background(color = colors.WHITE)
            ) {
                LogoutTopBar()
                StackKnowledgePager()
                Spacer(modifier = modifier.height(28.dp))
                MissionList()
                Spacer(modifier = modifier.height(20.dp))
                RankingList()
            }
        }
    }

}

@Preview
@Composable
fun MainPageScreenPre() {
    MainPageScreen()
}