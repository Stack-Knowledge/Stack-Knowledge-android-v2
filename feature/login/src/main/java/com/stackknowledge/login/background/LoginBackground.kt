package com.stackknowledge.login.background

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.stackknowledge.design_system.R

@Composable
fun LoginBackground(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(R.drawable.top_background),
            contentDescription = "Top Back Ground",
            modifier = modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Box(
            modifier = modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                painter = painterResource(R.drawable.bottom_background),
                contentDescription = "Bottom Back Ground"
            )
        }
    }
}

@Preview
@Composable
fun LoginBackgroundPre() {
    LoginBackground()
}