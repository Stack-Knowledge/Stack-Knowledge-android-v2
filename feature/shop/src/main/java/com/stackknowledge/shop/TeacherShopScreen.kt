package com.stackknowledge.shop

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.minstone.ui.navigation.StackKnowledgeBottomNavigation
import com.stackknowledge.design_system.component.dialog.StackKnowledgeDialog
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.shop.component.OrderedGoodsList
import com.stackknowledge.shop.viewmodel.OrderViewModel
import com.stackknowledge.shop.viewmodel.uistate.GetOrderListUiState
import enumdatatype.Authority
import remote.request.order.ChangeOrderStatusRequestModel
import com.stackknowledge.design_system.R

@Composable
internal fun TeacherShopRoute(
    onNavigate: (Authority, String) -> Unit,
    orderViewModel: OrderViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
) {
    val role = remember { mutableStateOf(Authority.ROLE_TEACHER) } //로그인 로직 적용후 변경
    val getOrderListUiState = orderViewModel.getOrderListUiState.collectAsStateWithLifecycle()

    with(orderViewModel) {
        TeacherShopScreen(
            role = role.value,
            onNavigate = { navType -> onNavigate(role.value, navType) },
            getOrderListUiState = getOrderListUiState.value,
            initTeacherShop = {
                viewAllOrder()
            },
            onItemClick = { clickedItemId ->
                changeOrderStatus(ChangeOrderStatusRequestModel(clickedItemId, 1))
            }
        )
    }
}

@Composable
private fun TeacherShopScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    onNavigate: (String) -> Unit,
    onItemClick: (String) -> Unit,
    getOrderListUiState: GetOrderListUiState,
    initTeacherShop: () -> Unit,
) {
    val isDialogVisible = remember { mutableStateOf(false) }
    val itemIdSaved = remember { mutableStateOf("") }

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
                        itemIdSaved.value = clickedItemId
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
        }

        StackKnowledgeDialog(
            content = stringResource(id = R.string.discount_ordered_item),
            onConfirm = {
                onItemClick(itemIdSaved.value)
            },
            onDismiss = {
                isDialogVisible.value = false
            },
            openDialog = isDialogVisible.value,
            onStateChange = { isDialogVisible.value = it }
        )
    }
}