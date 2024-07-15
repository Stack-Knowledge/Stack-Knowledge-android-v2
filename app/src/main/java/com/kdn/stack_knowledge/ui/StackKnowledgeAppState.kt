package com.kdn.stack_knowledge.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.util.trace
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.kdn.stack_knowledge.navigation.TopLevelDestination
import com.stackknowledge.login.navigation.navigateToLogin
import com.stackknowledge.login.navigation.navigateToRoleCheck
import com.stackknowledge.login.navigation.roleCheckRoute
import com.stackknowledge.main.navigation.navigateToMain
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberStackKnowledgeAppState(
    windowSizeClass: WindowSizeClass,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): StackKnowledgeAppState {
    return remember(
        navController,
        coroutineScope,
        windowSizeClass
    ) {
        StackKnowledgeAppState(
            navController = navController,
            coroutineScope = coroutineScope,
            windowSizeClass = windowSizeClass
        )
    }
}

@Stable
class StackKnowledgeAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    val windowSizeClass: WindowSizeClass
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when(currentDestination?.route) {
            roleCheckRoute -> TopLevelDestination.ROLE_CHECK
            else -> null
        }

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
            }

            when (topLevelDestination) {
                TopLevelDestination.ROLE_CHECK -> navController.navigateToRoleCheck(topLevelNavOptions)
                TopLevelDestination.MAIN -> navController.navigateToMain(topLevelNavOptions)
            }
        }
    }
}