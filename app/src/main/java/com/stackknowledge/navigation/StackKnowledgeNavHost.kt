package com.stackknowledge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.stackknowledge.ui.StackKnowledgeAppState

@Composable
fun StackKnowledgeNavHost(
    appState: StackKnowledgeAppState,
    modifier: Modifier = Modifier,
    startDestination: String, // = 선생여부 묻는 스크린 Route <- 루트 추가
) {
    val navController = appState.navController

    // 아래의 NavHost의 startDestination은 GoogleOAuth작업 이후 학생 or 선생여부 묻는 스크린을 띄워주면 될 거 같아요
    // NavHost (
    // navController = navController,
    // startDestination = startDestination,
    // modifier = modfiier
    // )

}