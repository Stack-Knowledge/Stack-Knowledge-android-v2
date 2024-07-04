package com.stackknowledge.main.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.example.common.util.Event
import com.stackknowledge.main.viewModel.uistate.GetMissionUiState
import com.stackknowledge.usecase.mission.GetMissionUseCase
import com.stackknowledge.usecase.solve.SolveUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val getMissionUseCase: GetMissionUseCase
): ViewModel() {
    private val _getMissionUiState = MutableStateFlow<GetMissionUiState>(GetMissionUiState.Loading)
    val getMissionUiState = _getMissionUiState.asStateFlow()

    fun getMission() = viewModelScope.launch {
        getMissionUseCase()
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> _getMissionUiState.value = GetMissionUiState.Loading
                    is Result.Success -> {
                        Log.d("testt","suc")
                        _getMissionUiState.value = GetMissionUiState.Success(result.data)
                    }
                    is Result.Error -> {
                        Log.d("testt",result.exception.toString())
                        _getMissionUiState.value = GetMissionUiState.Error(result.exception)
                    }
                }
            }
    }
}