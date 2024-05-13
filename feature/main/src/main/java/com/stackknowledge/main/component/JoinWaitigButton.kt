package com.stackknowledge.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R

@Composable
fun JoinWaitingButton(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(R.drawable.join_waiting),
        contentDescription = "Join Waiting Button",
        modifier = modifier
            .width(60.dp)
            .height(60.dp)
    )

}

@Preview
@Composable
fun JoinWaitingButtonPre() {
    JoinWaitingButton()
}