package com.stackknowledge.usecase.mission

import com.stackknowledge.repository.mission.MissionRepository
import kotlinx.coroutines.flow.Flow
import remote.response.mission.MissionResponseModel
import javax.inject.Inject

class GetMissionUseCase @Inject constructor(
    private val missionRepository: MissionRepository
) {
    operator fun invoke(): Flow<List<MissionResponseModel>> =
        missionRepository.getMission()
}