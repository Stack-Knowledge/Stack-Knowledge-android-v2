package com.stackknowledge.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.example.common.util.Event
import com.stackknowledge.shop.viewmodel.uistate.GetItemUiState
import com.stackknowledge.usecase.item.GetItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import remote.response.item.GetItemResponseModel
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val getItemUseCase: GetItemUseCase
): ViewModel() {
    private val _getItemRequest = MutableStateFlow<GetItemUiState>(GetItemUiState.Loading)
    val getItemRequest = _getItemRequest.asStateFlow()

    fun getItem() = viewModelScope.launch {
        getItemUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getItemRequest.value = GetItemUiState.Loading
                    is Result.Success -> _getItemRequest.value = GetItemUiState.Success(result.data)
                    is Result.Error -> _getItemRequest.value = GetItemUiState.Error(result.exception)
                }
            }
    }
}