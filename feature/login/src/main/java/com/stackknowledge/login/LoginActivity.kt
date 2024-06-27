package com.stackknowledge.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CompositionLocalProvider {
                StackKnowledgeAndroidTheme { _, _ ->
                    LoginRoute()
                }
            }
        }
    }
}
