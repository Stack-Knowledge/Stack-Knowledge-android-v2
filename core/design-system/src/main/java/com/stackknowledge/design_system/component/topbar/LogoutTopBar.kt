package com.stackknowledge.design_system.component.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun LogoutTopBar(
    modifier: Modifier = Modifier,
) {
    StackKnowledgeAndroidTheme { colors, _ ->
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = colors.WHITE)
                .padding(9.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.stack_knowledge_logo),
                contentDescription = "Stack Knowledge Logo",
                modifier = modifier.padding(top = 7.dp, bottom = 7.dp)
            )
            Image(
                painter = painterResource(R.drawable.log_out),
                contentDescription = "Logout Button",
                modifier = modifier.padding(top = 11.dp, end = 7.dp)
            )
        }
    }
}

@Preview
@Composable
fun LogoutTopBarPre() {
    LogoutTopBar()
}