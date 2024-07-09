package com.stackkowledge.mission.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.example.common.util.Event
import com.example.common.util.errorHandling
import com.stackknowledge.usecase.solve.SolveUseCase
import com.stackkowledge.mission.viewmodel.uistate.SolveMissionUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import remote.request.solve.SolveRequestModel
import javax.inject.Inject

@HiltViewModel
class SolveMissionViewModel @Inject constructor(
    private val solveUseCase: SolveUseCase,
) : ViewModel() {
    private val _solveMissionUiState = MutableStateFlow<Event<Nothing>>(Event.Loading)
    internal val solveMissionUiState = _solveMissionUiState.asStateFlow()

    internal fun solveMission(missionId: String, solution: SolveRequestModel) = viewModelScope.launch {
        solveUseCase(missionId = missionId, solution = solution)
            .onSuccess {
                it.catch { remoteError ->
                    _solveMissionUiState.value = remoteError.errorHandling()
                }.collect {
                    _solveMissionUiState.value = Event.Success()
                }
            }
            .onFailure {
                _solveMissionUiState.value = it.errorHandling()
            }
    }
}