package com.stackknowledge.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.navigation.StackKnowledgeNavHost

@Composable
fun StackKnowledgeApp(
    windowSizeClass: WindowSizeClass,
    appState: StackKnowledgeAppState = rememberStackKnowledgeAppState(
        windowSizeClass = windowSizeClass
    ),
) {
    StackKnowledgeAndroidTheme { _, _ ->
        // StackKnowledgeNavHost(appState = appState, startDestination = ) <- 이부분도 startDestination 스크린 작업 후 추가
    }
}