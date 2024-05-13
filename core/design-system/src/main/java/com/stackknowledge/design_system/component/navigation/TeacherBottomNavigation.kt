package com.stackknowledge.design_system.component.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun TeacherBottomNavigation(
    modifier: Modifier = Modifier
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
                Column(
                    modifier = modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.home_icon),
                        contentDescription = "Home Icon"
                    )
                    Spacer(modifier = modifier.height(5.dp))
                    Text(
                        text = stringResource(R.string.home),
                        style = typography.bodySmall,
                        color = colors.BLACK
                    )
                }
                Column(
                    modifier = modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.mission_icon),
                        contentDescription = "Mission Icon"
                    )
                    Spacer(modifier = modifier.height(5.dp))
                    Text(
                        text = stringResource(R.string.mission),
                        style = typography.bodySmall,
                        color = colors.BLACK
                    )
                }
                Column(
                    modifier = modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.create_mission_icon),
                        contentDescription = "Create Mission Icon"
                    )
                    Spacer(modifier = modifier.height(5.dp))
                    Text(
                        text = stringResource(R.string.create_mission),
                        style = typography.bodySmall,
                        color = colors.BLACK
                    )
                }
                Column(
                    modifier = modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.shop_icon),
                        contentDescription = "Shop Icon"
                    )
                    Spacer(modifier = modifier.height(5.dp))
                    Text(
                        text = stringResource(R.string.shop),
                        style = typography.bodySmall,
                        color = colors.BLACK
                    )
                }
                Column(
                    modifier = modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.ranking_icon),
                        contentDescription = "Ranking Icon"
                    )
                    Spacer(modifier = modifier.height(5.dp))
                    Text(
                        text = stringResource(R.string.ranking),
                        style = typography.bodySmall,
                        color = colors.BLACK
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TeacherBottomNavigationPre() {
    TeacherBottomNavigation()
}