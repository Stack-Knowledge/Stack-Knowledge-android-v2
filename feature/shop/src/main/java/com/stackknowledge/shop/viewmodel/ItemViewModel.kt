package com.stackknowledge.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.stackknowledge.shop.viewmodel.uistate.GetItemUiState
import com.stackknowledge.shop.viewmodel.uistate.GetMyInformationUiState
import com.stackknowledge.usecase.item.GetItemUseCase
import com.stackknowledge.usecase.student.GetMyInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val getItemUseCase: GetItemUseCase,
    private val getMyInformationUseCase: GetMyInformationUseCase,
) : ViewModel() {
    private val _getItemUiState = MutableStateFlow<GetItemUiState>(GetItemUiState.Loading)
    internal val getItemUiState = _getItemUiState.asStateFlow()

    private val _getMyInformationUiState =
        MutableStateFlow<GetMyInformationUiState>(GetMyInformationUiState.Loading)
    internal val getMyInformationUiState = _getMyInformationUiState.asStateFlow()

    internal fun getItem() = viewModelScope.launch {
        getItemUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getItemUiState.value = GetItemUiState.Loading
                    is Result.Success -> _getItemUiState.value = GetItemUiState.Success(result.data)
                    is Result.Error -> _getItemUiState.value =
                        GetItemUiState.Error(result.exception)
                }
            }
    }

    internal fun getMyInformation() = viewModelScope.launch {
        getMyInformationUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getMyInformationUiState.value = GetMyInformationUiState.Loading
                    is Result.Success -> _getMyInformationUiState.value = GetMyInformationUiState.Success(result.data)
                    is Result.Error -> _getMyInformationUiState.value = GetMyInformationUiState.Error(result.exception)
                }
            }
    }
}