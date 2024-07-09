package com.stackknowledge.shop

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.minstone.ui.navigation.StackKnowledgeBottomNavigation
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.dialog.StackKnowledgeDialog
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.shop.component.OrderedGoodsList
import com.stackknowledge.shop.viewmodel.OrderViewModel
import com.stackknowledge.shop.viewmodel.uistate.GetOrderListUiState
import enumdatatype.Authority
import remote.request.order.ChangeOrderStatusRequestModel

@Composable
internal fun TeacherShopRoute(
    onNavigate: (Authority, String) -> Unit,
    orderViewModel: OrderViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
) {
    val role by remember { mutableStateOf(Authority.ROLE_TEACHER) } //로그인 로직 적용후 변경
    val getOrderListUiState by orderViewModel.getOrderListUiState.collectAsStateWithLifecycle()

    with(orderViewModel) {
        TeacherShopScreen(
            role = role,
            onNavigate = { navType -> onNavigate(role, navType) },
            getOrderListUiState = getOrderListUiState,
            initTeacherShop = {
                viewAllOrder()
            },
            onDiscountClick = { changeOrderStatusRequest ->
                changeOrderStatus(changeOrderStatusRequest)
            }
        )
    }
}

@Composable
private fun TeacherShopScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    onNavigate: (String) -> Unit,
    onDiscountClick: (ChangeOrderStatusRequestModel) -> Unit,
    getOrderListUiState: GetOrderListUiState,
    initTeacherShop: () -> Unit,
) {
    val isDialogVisible = remember { mutableStateOf(false) }
    val itemId = remember { mutableStateOf("") }

    LaunchedEffect(true) {
        initTeacherShop()
    }

    StackKnowledgeAndroidTheme { colors, _ ->
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .background(color = colors.WHITE)
            ) {
                StackKnowledgeTopBar()

                OrderedGoodsList(
                    getOrderListUiState = getOrderListUiState,
                    onItemClick = { clickedItemId ->
                        isDialogVisible.value = true
                        itemId.value = clickedItemId
                        Log.e("click event", isDialogVisible.value.toString())
                    }
                )
            }

            Box(
                modifier = Modifier.align(alignment = Alignment.BottomCenter),
            ) {
                StackKnowledgeBottomNavigation(
                    modifier = Modifier,
                    role = role
                ) {
                    onNavigate(it)
                }
            }

            StackKnowledgeDialog(
                content = stringResource(id = R.string.discount_ordered_item),
                onConfirm = {
                    isDialogVisible.value = false
                    onDiscountClick(
                        ChangeOrderStatusRequestModel(
                            orderId = itemId.value,
                            count = 1
                        )
                    )
                },
                onDismiss = {
                    isDialogVisible.value = false
                },
                openDialog = isDialogVisible.value,
                onStateChange = { isDialogVisible.value = it }
            )
        }
    }
}