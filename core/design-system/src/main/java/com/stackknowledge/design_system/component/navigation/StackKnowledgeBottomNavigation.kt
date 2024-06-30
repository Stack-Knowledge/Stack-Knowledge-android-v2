package com.stackknowledge.design_system.component.navigation

import android.icu.text.TimeZoneNames.NameType
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

enum class NavigateType(val value: String, val stringResId: Int) {
    HOME("home", R.string.home),
    MISSION("mission", R.string.mission),
    CREATE_MISSION("create_mission", R.string.create_mission),
    SHOP("shop", R.string.shop),
    RANKING("ranking", R.string.ranking)
}

@Composable
fun StackKnowledgeBottomNavigation(
    modifier: Modifier,
    role: Boolean, // 로그인 로직 적용후 변경
    onNavigate: (String) -> Unit,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Box(
            modifier = modifier.background(color = colors.WHITE),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(56.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val navItems = listOf(
                    Triple(R.drawable.home_icon, NavigateType.HOME.value, NavigateType.HOME.stringResId),
                    Triple(R.drawable.mission_icon, NavigateType.MISSION.value, NavigateType.MISSION.stringResId),
                    Triple(R.drawable.create_mission_icon, NavigateType.CREATE_MISSION.value, NavigateType.CREATE_MISSION.stringResId),
                    Triple(R.drawable.shop_icon, NavigateType.SHOP.value, NavigateType.SHOP.stringResId),
                    Triple(R.drawable.ranking_icon, NavigateType.RANKING.value, NavigateType.RANKING.stringResId)
                )

                navItems.forEachIndexed { index, (iconRes, navigateType, stringResId) ->
                    if (index != 2 || !role) { // 로그인 로직 적용후 변경
                        BottomNavigationComponent(
                            modifier = modifier
                                .weight(1f)
                                .height(56.dp),
                            buttonText = stringResId,
                            buttonImage = {
                                Image(
                                    painter = painterResource(iconRes),
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

@Composable
private fun BottomNavigationComponent(
    modifier: Modifier,
    buttonText: Int,
    buttonImage: @Composable () -> Unit,
    onClick: () -> Unit
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Column(
            modifier = modifier.clickable(onClick = onClick),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            buttonImage()
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = stringResource(id = buttonText),
                style = typography.bodySmall,
                color = colors.BLACK
            )
        }
    }
}

