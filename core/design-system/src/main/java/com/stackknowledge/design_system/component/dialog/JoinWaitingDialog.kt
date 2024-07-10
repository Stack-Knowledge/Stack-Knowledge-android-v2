package com.stackknowledge.design_system.component.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun JoinWaitingDialog(
    modifier: Modifier = Modifier,
    openDialog: Boolean,
    onStateChange: (Boolean) -> Unit,
    onAccept: () -> Unit,
    onRefuse: () -> Unit,
) {
    var openDialog by remember { mutableStateOf(openDialog) }

    if (openDialog) {
        StackKnowledgeAndroidTheme { colors, _ ->
            Dialog(onDismissRequest = { openDialog = false }) {
                Column(
                    modifier = modifier
                        .width(328.dp)
                        .height(345.dp)
                        .background(
                            color = colors.WHITE,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = modifier.height(18.dp))
                    Row(
                        modifier = modifier.padding(start = 276.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.close_icon),
                            contentDescription = "Close Icon",
                            modifier = modifier
                                .width(14.dp)
                                .height(14.dp)
                                .clickable { openDialog = false }
                        )
                    }
                    Spacer(modifier = modifier.height(28.dp))
                    LazyColumn() {
                        items(3) {
                            JoinWaitingList()
                            Spacer(modifier = modifier.height(24.dp))
                        }
                    }
                }
            }
        }
    } else {
        onStateChange(openDialog)
    }
}

@Preview
@Composable
fun JoinWaitingDialogPre() {
    JoinWaitingDialog(
        openDialog = true,
        onStateChange = {},
        onAccept = {},
        onRefuse = {},
    )
}