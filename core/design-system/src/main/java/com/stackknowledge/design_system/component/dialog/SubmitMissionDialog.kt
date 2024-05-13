package com.stackknowledge.design_system.component.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun SubmitMissionDialog(
    modifier: Modifier = Modifier,
    content: String,
    onQuit: () -> Unit,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Dialog(onDismissRequest = { onQuit() }) {
            Row(
                modifier = modifier
                    .width(328.dp)
                    .height(70.dp)
                    .background(color = colors.G4, shape = RoundedCornerShape(5.dp))
            ) {
                Spacer(modifier = modifier.width(16.dp))
                Row(
                    modifier = modifier.fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.submit_mission_icon),
                        contentDescription = "Submit Mission Icon",
                        modifier = modifier
                            .width(28.dp)
                            .height(28.dp)
                    )
                    Spacer(modifier = modifier.width(8.dp))
                    Text(
                        text = content,
                        style = typography.bodyLarge,
                        color = colors.BLACK
                    )
                }
                Spacer(modifier = modifier.width(90.dp))
                Column(
                    modifier = modifier.padding(top = 8.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.close_icon),
                        contentDescription = "Close Icon",
                        modifier = modifier
                            .width(8.dp)
                            .height(8.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SubmitMissionDialogPre() {
    SubmitMissionDialog(
        content = "문제가 제출되었습니다!"
    ) {}
}