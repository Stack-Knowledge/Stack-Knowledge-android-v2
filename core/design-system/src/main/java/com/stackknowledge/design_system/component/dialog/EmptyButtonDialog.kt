package com.stackknowledge.design_system.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import kotlinx.coroutines.delay

@Composable
fun EmptyButtonDialog(
    modifier: Modifier = Modifier,
    content: String,
    openDialog: Boolean,
    onDismiss: () -> Unit,
    onStateChange: (Boolean) -> Unit,
) {
    var openDialog by remember { mutableStateOf(openDialog) }

    LaunchedEffect(openDialog) {
        delay(2000L)
        onDismiss()
    }

    if (openDialog) {
        StackKnowledgeAndroidTheme { colors, typography ->
            Dialog(onDismissRequest = { openDialog = false }) {
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
                    verticalArrangement = Arrangement.Center,
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
                }
            }
        }
    } else {
        onStateChange(openDialog)
    }
}