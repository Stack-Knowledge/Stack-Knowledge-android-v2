package com.stackknowledge.main.viewModel

import androidx.lifecycle.ViewModel
import com.stackknowledge.usecase.mission.GetMissionUseCase
import com.stackknowledge.usecase.solve.SolveUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val getMissionUseCase: GetMissionUseCase
): ViewModel() {

}