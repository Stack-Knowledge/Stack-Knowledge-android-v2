package com.stackkowledge.mission.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.stackknowledge.usecase.solve.SolveUseCase
import com.stackkowledge.mission.viewmodel.uistate.SolveMissionUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import remote.request.solve.SolveRequestModel
import javax.inject.Inject

@HiltViewModel
class SolveMissionViewModel @Inject constructor(
    private val solveUseCase: SolveUseCase,
) : ViewModel() {
    private val _solveMissionUiState = MutableStateFlow<SolveMissionUiState>(
        SolveMissionUiState.Loading)
    internal val solveMissionUiState = _solveMissionUiState.asStateFlow()

    internal fun solveMission(missionId: String, solution: SolveRequestModel) = viewModelScope.launch {
        solveUseCase(missionId = missionId, solution = solution)
            .asResult()
            .collectLatest {
                when(it) {
                    is Result.Loading -> _solveMissionUiState.value = SolveMissionUiState.Loading
                    is Result.Success -> _solveMissionUiState.value = SolveMissionUiState.Success
                    is Result.Error -> _solveMissionUiState.value = SolveMissionUiState.Error(it.exception)
                }
            }
    }
}