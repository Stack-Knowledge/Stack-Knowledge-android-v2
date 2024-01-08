package com.stackknowledge.design_system.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.stackknowledge.design_system.R

val pretendard = FontFamily(
    Font(R.font.pretendard_regular),
    Font(R.font.pretendard_semibold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = pretendard,
        fontSize = 18.sp,
        fontWeight = FontWeight.W600,
        lineHeight = 25.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = pretendard,
        fontSize = 14.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = pretendard,
        fontSize = 12.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 22.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = pretendard,
        fontSize = 40.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 48.sp
    )
)