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
    startLogin:() -> Unit,
    isStudent: (Boolean) -> Unit,
    isTeacher: (Boolean) -> Unit,
) {
    StackKnowledgeAndroidTheme { _, _ ->
        StackKnowledgeNavHost(
            appState = appState,
            startLogin = { startLogin() },
            isStudent = isStudent,
            isTeacher = isTeacher,
        ) //startDestination = ) // <- 이부분도 startDestination 스크린 작업 후 추가
    }
}