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
<<<<<<< HEAD
        StackKnowledgeNavHost(
            appState = appState,
        )
=======
         StackKnowledgeNavHost(
             appState = appState,
             //startDestination = "" <- auth 작업후에 추가
         )
>>>>>>> 7968c9bc41ecc66967c282ccfb3222e458eb598b
    }
}