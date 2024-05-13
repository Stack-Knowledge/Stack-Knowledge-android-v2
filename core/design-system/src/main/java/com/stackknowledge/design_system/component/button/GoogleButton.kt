package com.stackknowledge.design_system.component.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun GoogleButton(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Button(
            onClick = {},
            modifier = modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = colors.G5),
            colors = ButtonDefaults.buttonColors(
                containerColor = colors.G5
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.google_logo),
                    contentDescription = "Google Logo",
                    modifier = modifier
                        .width(40.dp)
                        .height(40.dp)
                )
                Spacer(modifier = modifier.width(14.dp))
                Text(
                    text = stringResource(R.string.google_login),
                    style = typography.bodyLarge,
                    color = colors.BLACK
                )
            }
        }
    }
}

@Preview
@Composable
fun GoogleButtonPre() {
    GoogleButton()
}