package com.stackknowledge.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import com.stackknowledge.login.LoginActivity
import com.stackknowledge.login.navigation.loginRoute
import com.stackknowledge.login.navigation.loginScreen
import com.stackknowledge.login.navigation.navigateToLogin
import com.stackknowledge.ui.StackKnowledgeAppState

@Composable
fun StackKnowledgeNavHost(
    appState: StackKnowledgeAppState,
    startLogin: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String,
) {
    val navController = appState.navController

    // 아래의 NavHost의 startDestination은 GoogleOAuth작업 이후 학생 or 선생여부 묻는 스크린을 띄워주면 될 거 같아요
     NavHost (
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
     ) {
         loginScreen(

         )
     }
}