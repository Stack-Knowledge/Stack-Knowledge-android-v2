package com.stackknowledge.design_system.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun JoinWaitingList(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Row {
            Text(
                text = "이승제 - 2024.01.05",
                style = typography.bodyMedium,
                color = colors.BLACK
            )
            Spacer(modifier = modifier.width(16.dp))
            Box(
                modifier = modifier
                    .width(45.dp)
                    .height(21.dp)
                    .background(
                        color = colors.P1, shape = RoundedCornerShape(2.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.accept),
                    style = typography.bodySmall,
                    color = colors.WHITE
                )
            }
            Spacer(modifier = modifier.width(8.dp))
            Box(
                modifier = modifier
                    .width(45.dp)
                    .height(21.dp)
                    .background(
                        color = colors.G5, shape = RoundedCornerShape(2.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.refusal),
                    style = typography.bodySmall,
                    color = colors.BLACK
                )
            }
        }
    }
}

@Preview
@Composable
fun JoinWaitingListPre() {
    JoinWaitingList()
}