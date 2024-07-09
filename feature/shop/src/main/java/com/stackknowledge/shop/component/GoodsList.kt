package com.stackknowledge.shop.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.button.StackKnowledgeButton
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.shop.data.SelectedItemData
import com.stackknowledge.shop.viewmodel.uistate.GetItemUiState
import remote.response.item.GetItemResponseModel

@Composable
fun GoodsList(
    modifier: Modifier = Modifier,
    getItemUiState: GetItemUiState,
    selectedItemList: MutableList<SelectedItemData>,
    onSelectButtonClick: (List<GetItemResponseModel>) -> Unit,
    onOrderButtonClick: () -> Unit,
) {
    val selectedDisplayItemList = remember { mutableListOf<GetItemResponseModel>() }
    val isBottomSheetVisible = remember { mutableStateOf(false) }

    StackKnowledgeAndroidTheme { colors, typography ->
        Column(
            modifier = modifier
                .background(color = colors.WHITE)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.goods),
                style = typography.bodyLarge,
                color = colors.BLACK,
                modifier = modifier
                    .padding(start = 16.dp)
            )

            Spacer(modifier = modifier.height(16.dp))
            when (getItemUiState) {
                is GetItemUiState.Success -> {
                    val itemList = getItemUiState.getItemResponseModel

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = modifier.height(272.dp)
                    ) {
                        items(itemList) { item ->
                            Box(
                                modifier = modifier
                                    .padding(horizontal = 16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                GoodsItem(
                                    itemData = item,
                                    onItemCheckButtonClick = { selectedItem ->
                                        selectedDisplayItemList.add(selectedItem)
                                    },
                                    onItemUnCheckButtonClick = { unselectedItem ->
                                        selectedDisplayItemList.removeIf { selectedItemListElement ->
                                            selectedItemListElement.id == unselectedItem.id
                                        }
                                    }
                                )
                            }
                        }
                    }
                }

                is GetItemUiState.Error -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "상품이 존재하지 않아요!"
                        )
                    }
                }

                is GetItemUiState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "상품을 불러오는 중.."
                        )
                    }
                }
            }

            Spacer(modifier = modifier.height(32.dp))

            Box(
                modifier = modifier
                    .padding(horizontal = 16.dp),
            ) {
                StackKnowledgeButton(
                    text = stringResource(id = R.string.select),
                    modifier = modifier
                        .height(60.dp),
                    onClick = {
                        onSelectButtonClick(selectedDisplayItemList)
                        isBottomSheetVisible.value = true
                    }
                )
            }

            Spacer(modifier = modifier.height(100.dp))
        }

        if (isBottomSheetVisible.value) {
            OrderBottomSheet(
                onQuit = {
                    isBottomSheetVisible.value = false
                },
                selectedItemList = selectedItemList,
                onOrderButtonClick = {
                    onOrderButtonClick()
                }
            )
        }
    }
}

@Preview
@Composable
fun GoodsListPre() {
    GoodsList(
        getItemUiState = GetItemUiState.Success(listOf()),
        onSelectButtonClick = {},
        onOrderButtonClick = {},
        selectedItemList = mutableListOf()
    )
}