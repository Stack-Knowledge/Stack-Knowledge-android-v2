package com.stackknowledge.design_system.component.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun StackKnowledgeDialog(
    modifier: Modifier = Modifier,
    content: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    openDialog: Boolean,
) {
    var openDialog by remember { mutableStateOf(openDialog) }

    StackKnowledgeAndroidTheme { colors, typography ->
        Dialog(onDismissRequest = { openDialog = false } )  {
            Column(
                modifier = modifier
                    .width(280.dp)
                    .height(150.dp)
                    .background(
                        color = colors.WHITE,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    text = content,
                    style = typography.bodyMedium,
                    color = colors.BLACK,
                    modifier = modifier
                        .wrapContentWidth()
                        .wrapContentHeight(),
                    textAlign = TextAlign.Center
                )
                Row() {
                    Button(
                        modifier = modifier
                            .width(116.dp)
                            .height(40.dp),
                        onClick = onDismiss,
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
                        onClick = onConfirm,
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
fun StackKnowledgeDialogPre() {
    StackKnowledgeDialog(
        content = "로그아웃 하시겠습니까?",
        onConfirm = {},
        onDismiss = {},
        openDialog = false,
    )
}