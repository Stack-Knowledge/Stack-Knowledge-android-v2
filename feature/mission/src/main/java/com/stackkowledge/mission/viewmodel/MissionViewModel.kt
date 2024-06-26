package com.stackkowledge.mission.viewmodel

import androidx.lifecycle.ViewModel
import com.stackknowledge.misson.CreateMissionUseCase
import com.stackknowledge.misson.DetailMissionUseCase
import com.stackknowledge.misson.GetMissionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MissionViewModel @Inject constructor(
    private val getMissionRequest: GetMissionUseCase,
    private val detailMissionUseCase: DetailMissionUseCase,
    private val createMissionUseCase: CreateMissionUseCase,
): ViewModel() {
    
}