package com.stackknowledge.design_system.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun StackKnowledgeButton(
    modifier: Modifier = Modifier,
    text: String,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Button(
            onClick = { /*TODO*/ },
            modifier = modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = colors.P1),
            colors = ButtonDefaults.buttonColors(
                containerColor = colors.P1
            )
        ) {
            Text(
                text = text,
                color = colors.WHITE,
                style = typography.headlineSmall,
                modifier = modifier.padding(vertical = 17.dp)
            )
        }
    }
}

@Preview
@Composable
fun StackKnowledgeButtonPre() {
    StackKnowledgeButton(
        text = "제출하기"
    )
}