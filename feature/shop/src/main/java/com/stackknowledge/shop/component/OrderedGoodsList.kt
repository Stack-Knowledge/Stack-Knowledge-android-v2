package com.stackknowledge.shop.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.shop.viewmodel.uistate.GetOrderListUiState

@Composable
fun OrderedGoodsList(
    modifier: Modifier = Modifier,
    getOrderListUiState: GetOrderListUiState,
    onItemClick: (String) -> Unit,
) {
    StackKnowledgeAndroidTheme { colors, _ ->
        Column(
            modifier = modifier
                .background(color = colors.WHITE)
                .fillMaxSize()
        ) {
            when (getOrderListUiState) {
                is GetOrderListUiState.Success -> {
                    val orderList = getOrderListUiState.viewOrderListResponseModel

                    LazyVerticalGrid(
                        modifier = modifier.fillMaxSize(),
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(
                            start = 16.dp,
                            top = 16.dp,
                        ),
                    ) {
                        items(orderList) { orderedItem ->
                            Box {
                                OrderedGoodsItem(
                                    orderedItemData = orderedItem,
                                    onItemClick = { clickedItemId ->
                                        onItemClick(clickedItemId)
                                    }
                                )
                            }
                        }
                    }
                }

                is GetOrderListUiState.Error -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "주문된 상품이 존재하지 않아요!"
                        )
                    }
                }

                is GetOrderListUiState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "주문된 상품 불러오는 중.."
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun OrderedGoodsListPre() {
    OrderedGoodsList(
        getOrderListUiState = GetOrderListUiState.Success(listOf()),
        onItemClick = {}
    )
}