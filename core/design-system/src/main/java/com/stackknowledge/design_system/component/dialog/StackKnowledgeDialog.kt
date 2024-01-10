package com.stackknowledge.design_system.component.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun LogoutDialog(
    modifier: Modifier = Modifier,
    content: String,
    onQuit: () -> Unit,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Dialog(onDismissRequest = { onQuit() } )  {
            Column(
                modifier = modifier
                    .width(280.dp)
                    .height(150.dp)
                    .background(
                        color = colors.WHITE,
                        shape = RoundedCornerShape(20.dp)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = modifier.height(44.dp))
                Text(
                    text = content,
                    style = typography.bodyMedium,
                    color = colors.BLACK
                )
                Spacer(modifier = modifier.height(35.dp))
                Row() {
                    Button(
                        modifier = modifier
                            .width(116.dp)
                            .height(40.dp),
                        onClick = {},
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            colors.P1
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.cancel),
                            style = typography.bodyMedium,
                            color = colors.WHITE
                        )
                    }
                    Spacer(modifier = modifier.width(16.dp))
                    OutlinedButton(
                        modifier = modifier
                            .width(116.dp)
                            .height(40.dp),
                        onClick = {},
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(1.dp, colors.P1),
                        colors = ButtonDefaults.buttonColors(
                            colors.WHITE
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.check),
                            style = typography.bodyMedium,
                            color = colors.P1
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LogoutDialogPre() {
    LogoutDialog(
        content = "로그아웃 하시겠습니까?"
    ) {}
}