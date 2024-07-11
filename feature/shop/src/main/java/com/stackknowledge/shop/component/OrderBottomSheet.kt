package com.stackknowledge.shop.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.button.StackKnowledgeButton
import com.stackknowledge.design_system.component.button.enumclass.ButtonState
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.shop.data.SelectedItemData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderBottomSheet(
    modifier: Modifier = Modifier,
    selectedItemList: MutableList<SelectedItemData>,
    onQuit: () -> Unit,
    onOrderButtonClick: () -> Unit,
) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val totalAmount = remember { mutableIntStateOf(0) }

    LaunchedEffect(selectedItemList) {
        totalAmount.intValue = selectedItemList.sumOf { it.count * it.price }
    }

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
                LazyColumn {
                    items(selectedItemList) { item ->
                        OrderBottomSheetItem(
                            item = item,
                            selectedItemList = selectedItemList,
                            onItemCountChanged = {
                                totalAmount.intValue = selectedItemList.sumOf { it.count * it.price }
                            }
                        )

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
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Spacer(modifier = modifier.weight(1f))

                    Text(
                        text = stringResource(R.string.total_amount),
                        style = typography.bodyMedium,
                        color = colors.BLACK
                    )

                    Spacer(modifier = modifier.width(4.dp))

                    Text(
                        text = "${totalAmount.intValue}",
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
                    enable = ButtonState.ACTIVATE,
                    modifier = modifier
                        .height(60.dp)
                ) {
                    onOrderButtonClick()
                }

                Spacer(modifier = modifier.height(24.dp))
            }
        }
    }
}

@Preview
@Composable
fun OrderBottomSheetPre() {
    OrderBottomSheet(
        onOrderButtonClick = {},
        onQuit = {},
        selectedItemList = mutableListOf(
            SelectedItemData(
                id = "1",
                name = "정영운 글러브",
                price = 1000,
                count = 1
            )
        )
    )
}