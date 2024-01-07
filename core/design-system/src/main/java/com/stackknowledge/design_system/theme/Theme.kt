package com.stackknowledge.design_system.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import com.stackknowledge.design_system.theme.color.ColorTheme
import com.stackknowledge.design_system.theme.color.StackKnowledgeColor

@Composable
fun StackKnowledgeAndroidTheme(
    colors: ColorTheme = StackKnowledgeColor,
    typography: Typography = Typography,
    content: @Composable (colors: ColorTheme, typography: Typography) -> Unit
) {
    content(colors, typography)
}