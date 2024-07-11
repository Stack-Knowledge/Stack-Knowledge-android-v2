package com.stackknowledge.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.minstone.ui.navigation.StackKnowledgeBottomNavigation
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.shop.component.CurrentMileage
import com.stackknowledge.shop.component.GoodsList
import enumdata.Authority

@Composable
internal fun ShopRoute(
    onNavigate: (Authority, String) -> Unit,
) {
    var role by remember { mutableStateOf(Authority.ROLE_STUDENT) } //로그인 로직 적용후 변경

    ShopScreen(
        role = role,
        onNavigate = { navType -> onNavigate(role, navType)}
    )
}

@Composable
private fun ShopScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    onNavigate: (String) -> Unit,
) {
    StackKnowledgeAndroidTheme { colors, _ ->
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .background(color = colors.WHITE)
            ) {
                StackKnowledgeTopBar()

                Spacer(modifier = modifier.height(47.dp))
                
                CurrentMileage()
                
                Spacer(modifier = modifier.height(60.dp))

                GoodsList()
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