package com.stackknowledge.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.util.Event
import com.example.common.util.errorHandling
import com.stackknowledge.usecase.item.GetItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import remote.response.item.GetItemResponseModel
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val getItemUseCase: GetItemUseCase
): ViewModel() {
    private val _getItemRequest = MutableStateFlow<Event<GetItemResponseModel>>(Event.Loading)
    val getItemRequest = _getItemRequest.asStateFlow()

    fun getItem() = viewModelScope.launch { 
        getItemUseCase()
            .onSuccess {
                it.catch { remoteError ->
                    _getItemRequest.value = remoteError.errorHandling()
                }.collect { response ->
                    _getItemRequest.value = Event.Success(data = response)
                }
            }
            .onFailure {
                _getItemRequest.value = it.errorHandling()
            }
    }
}