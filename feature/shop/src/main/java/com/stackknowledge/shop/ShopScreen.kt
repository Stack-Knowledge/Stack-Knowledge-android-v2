package com.stackknowledge.shop

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.minstone.ui.navigation.StackKnowledgeBottomNavigation
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.dialog.OrderDialog
import com.stackknowledge.design_system.component.topbar.StackKnowledgeTopBar
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.shop.component.CurrentMileage
import com.stackknowledge.shop.component.GoodsList
import com.stackknowledge.shop.data.SelectedItemData
import com.stackknowledge.shop.viewmodel.ItemViewModel
import com.stackknowledge.shop.viewmodel.OrderViewModel
import com.stackknowledge.shop.viewmodel.uistate.GetItemUiState
import com.stackknowledge.shop.viewmodel.uistate.GetMyInformationUiState
import enumdatatype.Authority
import remote.response.item.GetItemResponseModel

@Composable
internal fun ShopRoute(
    onNavigate: (Authority, String) -> Unit,
    orderViewModel: OrderViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    itemViewModel: ItemViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
) {
    val role by remember { mutableStateOf(Authority.ROLE_STUDENT) } //로그인 로직 적용후 변경
    val getItemUiState by itemViewModel.getItemUiState.collectAsStateWithLifecycle()
    val getMyInformationUiState by itemViewModel.getMyInformationUiState.collectAsStateWithLifecycle()

    ShopScreen(
        role = role,
        getItemUiState = getItemUiState,
        getMyInformationUiState = getMyInformationUiState,
        onSelectButtonClick = { selectedItemList ->
            orderViewModel.setOrderDataList(selectedItemList)
        },
        selectedItemList = orderViewModel.selectedItemList,
        onOrderDialogButtonClick = {
            orderViewModel.order()
        },
        onNavigate = { navType -> onNavigate(role, navType) },
        initShop = {
            itemViewModel.getItem()
            itemViewModel.getMyInformation()
        }
    )
}

@Composable
private fun ShopScreen(
    modifier: Modifier = Modifier,
    role: Authority,
    getItemUiState: GetItemUiState,
    getMyInformationUiState: GetMyInformationUiState,
    onSelectButtonClick: (List<GetItemResponseModel>) -> Unit,
    onOrderDialogButtonClick: () -> Unit,
    selectedItemList: MutableList<SelectedItemData>,
    onNavigate: (String) -> Unit,
    initShop: () -> Unit
) {
    val isDialogVisible = remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        initShop()
    }

    StackKnowledgeAndroidTheme { colors, _ ->
        Box(
            modifier = modifier.fillMaxSize()
                .background(color = colors.WHITE)

        ) {
            Column {
                StackKnowledgeTopBar()

                Spacer(modifier = modifier.height(47.dp))

                CurrentMileage(
                    getMyInformationUiState = getMyInformationUiState
                )

                Spacer(modifier = modifier.height(60.dp))

                GoodsList(
                    getItemUiState = getItemUiState,
                    onSelectButtonClick = { selectedItemList ->
                        onSelectButtonClick(selectedItemList)
                    },
                    selectedItemList = selectedItemList,
                    onOrderButtonClick = {
                        isDialogVisible.value = true
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

            OrderDialog(
                content = stringResource(id = R.string.order_dialog_text),
                isVisible = isDialogVisible.value,
                onQuit = {
                    isDialogVisible.value = it
                },
                onOrderDialogButtonClick = {
                    onOrderDialogButtonClick()
                },
            )
        }
    }
}


@Preview
@Composable
fun ShopScreenPre() {
    ShopScreen(
        role = Authority.ROLE_STUDENT,
        getItemUiState = GetItemUiState.Loading,
        getMyInformationUiState = GetMyInformationUiState.Loading,
        onSelectButtonClick = {},
        onOrderDialogButtonClick = {},
        onNavigate = {},
        selectedItemList = mutableListOf(),
        initShop = {}
    )
}
