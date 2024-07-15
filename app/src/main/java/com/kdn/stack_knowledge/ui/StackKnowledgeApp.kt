package com.kdn.stack_knowledge.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.kdn.stack_knowledge.navigation.StackKnowledgeNavHost

@Composable
fun StackKnowledgeApp(
    windowSizeClass: WindowSizeClass,
    appState: StackKnowledgeAppState = rememberStackKnowledgeAppState(
        windowSizeClass = windowSizeClass
    ),
    onLoginButtonClick: () -> Unit = {},
    onLogout: () -> Unit,
) {
    StackKnowledgeAndroidTheme { _, _ ->
        StackKnowledgeNavHost(
            appState = appState,
            onLoginButtonClick = onLoginButtonClick,
            onLogout = onLogout
        )
    }
}