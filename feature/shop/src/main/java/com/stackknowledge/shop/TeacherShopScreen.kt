package com.stackknowledge.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.shop.component.OrderedGoodsList

@Composable
fun TeacherShopScreen(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Surface (
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
        }
    }
}

@Preview
@Composable
fun TeacherShoScreenPre() {
    TeacherShopScreen()
}