package com.stackknowledge.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.button.GoogleButton
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.login.background.LoginBackground

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Surface {
            Column(
                modifier = modifier.fillMaxSize()
            ) {
                Box() {
                    LoginBackground()
                    Column(
                        modifier = modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = modifier.height(157.dp))
                        Image(
                            painter = painterResource(R.drawable.stack_knowledge_logo),
                            contentDescription = "Stack Knowledge Logo",
                            modifier = modifier
                                .width(50.dp)
                                .height(50.dp)
                        )
                        Spacer(modifier = modifier.height(20.dp))
                        Text(
                            text = stringResource(R.string.app_title),
                            style = typography.titleLarge,
                            color = colors.BLACK
                        )
                        Spacer(modifier = modifier.height(360.dp))
                        Column(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {
                            GoogleButton(
                                modifier = modifier.height(60.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPre() {
    LoginScreen()
}