package com.stackknowledge.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun JoinWaitingButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    StackKnowledgeAndroidTheme { colors, _ ->
        FloatingActionButton(
            modifier = modifier,
            onClick = onClick,
            shape = CircleShape,
            containerColor = colors.P1,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.join_waiting),
                contentDescription = "Join Waiting Button",
                tint = Color.Unspecified
            )
        }
    }
}

@Preview
@Composable
fun JoinWaitingButtonPre() {
    JoinWaitingButton() {}
}