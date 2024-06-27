package com.stackknowledge.resolve_mission.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.util.Event
import com.example.common.util.errorHandling
import com.stackknowledge.usecase.solve.SolveUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import remote.request.solve.SolveRequestModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class SolveViewModel @Inject constructor(
    private val solveUseCase: SolveUseCase
): ViewModel() {
    private val _solveRequest = MutableStateFlow<Event<Nothing>>(Event.Loading)
    val solveRequest = _solveRequest.asStateFlow()

    internal fun solveMission(missionId: UUID, solution: SolveRequestModel) = viewModelScope.launch {
        solveUseCase(missionId = missionId, solution = solution)
            .onSuccess {
                _solveRequest.value = Event.Success()
            }
            .onFailure {
                _solveRequest.value = it.errorHandling()
            }
    }
}