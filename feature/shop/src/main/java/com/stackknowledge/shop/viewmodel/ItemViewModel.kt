package com.stackknowledge.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.stackknowledge.shop.viewmodel.uistate.GetItemUiState
import com.stackknowledge.usecase.item.GetItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val getItemUseCase: GetItemUseCase,
) : ViewModel() {
    private val _getItemUiState = MutableStateFlow<GetItemUiState>(GetItemUiState.Loading)
    internal val getItemUiState = _getItemUiState.asStateFlow()

    internal fun getItem() = viewModelScope.launch {
        getItemUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getItemUiState.value = GetItemUiState.Loading
                    is Result.Success -> _getItemUiState.value = GetItemUiState.Success(result.data)
                    is Result.Error -> _getItemUiState.value = GetItemUiState.Error(result.exception)
                }
            }
    }
}