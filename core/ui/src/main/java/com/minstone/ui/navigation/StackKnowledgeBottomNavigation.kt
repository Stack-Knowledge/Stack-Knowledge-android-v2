package com.minstone.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import enumdata.Authority

enum class NavigateType(val value: String) {
    HOME("home"),
    MISSION("mission"),
    CREATE_MISSION("create_mission"),
    SHOP("shop"),
    RANKING("ranking")
}

@Composable
fun StackKnowledgeBottomNavigation(
    modifier: Modifier,
    role: Authority,
    locate: NavigateType,
    onNavigate: (String) -> Unit,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Box(
            modifier = modifier.background(color = colors.WHITE),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column {
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFFF1F1F1)
                )
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val navItems = listOf(
                        Triple(R.drawable.home_icon, NavigateType.HOME.value, R.string.home),
                        Triple(R.drawable.mission_icon, NavigateType.MISSION.value, if(role == Authority.ROLE_STUDENT) R.string.mission else R.string.solved_mission),
                        Triple(R.drawable.create_mission_icon, NavigateType.CREATE_MISSION.value, R.string.create_mission),
                        Triple(R.drawable.shop_icon, NavigateType.SHOP.value, R.string.shop),
                        Triple(R.drawable.ranking_icon, NavigateType.RANKING.value, R.string.ranking)
                    )

                    navItems.forEachIndexed { index, (iconRes, navigateType, stringResId) ->
                        if (index != 2 || role == Authority.ROLE_TEACHER) {
                            BottomNavigationComponent(
                                modifier = modifier
                                    .weight(1f)
                                    .height(56.dp),
                                buttonText = stringResId,
                                isLocate = locate.value == navigateType,
                                buttonImage = {
                                    Image(
                                        painter = painterResource(iconRes),
                                        colorFilter = if(locate.value == navigateType) ColorFilter.tint(colors.P1) else null,
                                        contentDescription = null
                                    )
                                }
                            ) {
                                onNavigate(navigateType)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun BottomNavigationComponent(
    modifier: Modifier,
    buttonText: Int,
    isLocate: Boolean,
    buttonImage: @Composable () -> Unit,
    onClick: () -> Unit
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Column(
            modifier = modifier.clickable(onClick = onClick),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            buttonImage()
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = stringResource(id = buttonText),
                style = typography.bodySmall,
                color = if (isLocate) colors.P1 else colors.BLACK
            )
        }
    }
}

