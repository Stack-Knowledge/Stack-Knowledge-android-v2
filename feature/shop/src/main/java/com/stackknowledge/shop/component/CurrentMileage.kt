package com.stackknowledge.shop.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.design_system.R

@Composable
fun CurrentMileage(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->  
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(color = colors.WHITE),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.current_mileage),
                style = typography.headlineSmall,
                color = colors.BLACK
            )

            Spacer(modifier = modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "1,000",
                    style = typography.headlineLarge,
                    color = colors.BLACK
                )

                Spacer(modifier = modifier.width(4.dp))
                Text(
                    text = stringResource(R.string.mileage),
                    style = typography.headlineSmall,
                    color = colors.BLACK
                )
            }
        }
    }
}

@Preview
@Composable
fun CurrentMileagePre() {
    CurrentMileage()
}