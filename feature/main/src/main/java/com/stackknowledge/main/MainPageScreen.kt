package com.stackknowledge.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.component.navigation.StudentBottomNavigation
import com.stackknowledge.design_system.component.navigation.TeacherBottomNavigation
import com.stackknowledge.design_system.component.topbar.LogoutTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.main.component.MissionList
import com.stackknowledge.main.component.RankingList
import com.stackknowledge.main.component.StackKnowledgePager
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
internal fun MainPageRoute() {
    var role by remember { mutableStateOf(true) } //로그인 로직 적용후 변경
    MainPageScreen(
        role = role
    )
}

@Composable
private fun MainPageScreen(
    modifier: Modifier = Modifier,
    role: Boolean,
) {
    StackKnowledgeAndroidTheme { colors, _ ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = colors.WHITE)
        ) {
            Column{
                LogoutTopBar()
                StackKnowledgePager()
                Spacer(modifier = modifier.height(28.dp))
                MissionList()
                Spacer(modifier = modifier.height(20.dp))
                RankingList()
            }
            Box(
                modifier = Modifier.align(alignment = Alignment.BottomCenter),
            ) {
                if (role) {
                    StudentBottomNavigation(
                        onHomeClick = { /*TODO*/ },
                        onMissionClick = { /*TODO*/ },
                        onShopClick = { /*TODO*/ },
                        onRankingClick = {}
                    )
                } else {
                    TeacherBottomNavigation(
                        onHomeClick = { /*TODO*/ },
                        onMissionClick = { /*TODO*/ },
                        onMakeMissionClick = { /*TODO*/ },
                        onShopClick = { /*TODO*/ },
                        onRankingClick = {}
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun MainPageScreenPre() {
    MainPageScreen(
        role = false
    )
}