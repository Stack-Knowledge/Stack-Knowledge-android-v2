package com.stackknowledge.login

import androidx.compose.foundation.background
import com.stackknowledge.design_system.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.component.button.StackKnowledgeButton
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.login.background.LoginBackground

@Composable
internal fun RoleCheckScreenRoute() {
    RoleCheckScreen()
}

@Composable
private fun RoleCheckScreen(
    modifier: Modifier = Modifier,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Box(
            modifier = modifier.background(color = colors.WHITE),
        ) {
            LoginBackground()
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = modifier.height(260.dp))

                Text(
                    text = stringResource(id = R.string.select_role_text),
                    style = typography.titleMedium,
                    color = colors.BLACK,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = modifier.weight(1f))

                Row(
                    modifier = modifier.fillMaxWidth()
                ) {
                    StackKnowledgeButton(
                        text = stringResource(id = R.string.student),
                        modifier = modifier
                            .height(60.dp)
                            .weight(1f)
                    )

                    Spacer(modifier = modifier.width(8.dp))

                    StackKnowledgeButton(
                        text = stringResource(id = R.string.teacher),
                        modifier = modifier
                            .height(60.dp)
                            .weight(1f)
                    )
                }

                Spacer(modifier = modifier.height(102.dp))
            }
        }
    }
}

@Preview
@Composable
fun RoleCheckScreenPre() {
    RoleCheckScreen()
}