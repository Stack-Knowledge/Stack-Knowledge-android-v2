package com.stackknowledge.design_system.component.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun LogoutTopBar(
    modifier: Modifier = Modifier,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = colors.WHITE)
                .padding(9.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.stack_knowledge_logo),
                contentDescription = "Stack Knowledge Logo",
                modifier = modifier
                    .width(36.dp)
                    .height(36.dp)
                    .padding(top = 7.dp, bottom = 7.dp)
            )
            Spacer(modifier = modifier.width(6.dp))
            Text(
                text = stringResource(R.string.app_title),
                style = typography.titleMedium,
                color = colors.BLACK,
                modifier = modifier.padding(top = 7.dp, bottom = 7.dp)
            )
            Box(
                modifier = modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Image(
                    painter = painterResource(R.drawable.log_out),
                    contentDescription = "Logout Button",
                    modifier = modifier.padding(top = 7.dp, end = 7.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun LogoutTopBarPre() {
    LogoutTopBar()
}