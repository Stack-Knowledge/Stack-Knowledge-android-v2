package com.stackknowledge.design_system.component.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.button.StackKnowledgeButton
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StackKnowledgeBottomSheet(
    modifier: Modifier = Modifier,
    onQuit: () -> Unit,
) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    StackKnowledgeAndroidTheme { colors, typography ->
        ModalBottomSheet(
            onDismissRequest = {
                onQuit()
            },
            sheetState = bottomSheetState
        ) {
            Column(
                modifier = modifier
                    .padding(horizontal = 16.dp)
            ) {
                LazyColumn() {
                    items(10) {
                        BottomSheetItem()
                        Spacer(modifier = modifier.height(10.dp))
                    }
                }

                Spacer(
                    modifier = modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(color = colors.G1)
                )

                Spacer(modifier = modifier.height(8.dp))
                Row(
                    modifier = modifier.padding(start = 288.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.total_amount),
                        style = typography.bodyMedium,
                        color = colors.BLACK
                    )

                    Spacer(modifier = modifier.width(4.dp))

                    Text(
                        text = "1,000",
                        style = typography.bodyMedium,
                        color = colors.BLACK
                    )

                    Text(
                        text = stringResource(R.string.mileage),
                        style = typography.bodySmall,
                        color = colors.BLACK
                    )
                }

                Spacer(modifier = modifier.height(8.dp))
                StackKnowledgeButton(
                    text = stringResource(id = R.string.purchase),
                    modifier = modifier
                        .height(60.dp)
                )

                Spacer(modifier = modifier.height(24.dp))
            }
        }

    }
}

@Preview
@Composable
fun StackKnowledgeBottomSheetPre() {
    StackKnowledgeBottomSheet {}
}