package com.stackknowledge.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.minstone.ui.navigation.StackKnowledgeBottomNavigation
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.shop.component.OrderedGoodsList
import enumdata.Authority

@Composable
internal fun TeacherShopRoute(
    onNavigate: (Authority, String) -> Unit,
) {
    var role by remember { mutableStateOf(Authority.ROLE_TEACHER) } //로그인 로직 적용후 변경
    TeacherShopScreen(
        role = role,
        onNavigate = { navType -> onNavigate(role, navType) }
    )
}

@Composable
private fun TeacherShopScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    onNavigate: (String) -> Unit,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Box (
            modifier = modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .background(color = colors.WHITE)
            ) {
                StackKnowledgeTopBar()

                OrderedGoodsList()
            }
            Box(
                modifier = Modifier.align(alignment = Alignment.BottomCenter),
            ) {
                StackKnowledgeBottomNavigation(
                    modifier = Modifier,
                    role = role
                ) {
                    onNavigate(it)
                }
            }
        }
    }
}