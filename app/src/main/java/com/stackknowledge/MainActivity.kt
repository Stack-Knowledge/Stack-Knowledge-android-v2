package com.stackknowledge

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.login.LoginActivity
import com.stackknowledge.login.viewmodel.AuthViewModel
import com.stackknowledge.ui.StackKnowledgeApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var isStudent = false
    private var isTeacher = false

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider {
                StackKnowledgeAndroidTheme { _, _ ->
                    StackKnowledgeApp(
                        windowSizeClass = calculateWindowSizeClass(this@MainActivity),
                        startLogin = { startLogin() },
                        isStudent = { isStudent = it },
                        isTeacher = { isTeacher = it },
                    )
                }
            }
        }
    }

    private fun startLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("isStudent", isStudent)
        startActivity(intent)
    }
}
