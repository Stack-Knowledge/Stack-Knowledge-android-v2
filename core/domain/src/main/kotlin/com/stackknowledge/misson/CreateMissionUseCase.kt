package com.stackknowledge.misson

import com.stackknowledge.repository.mission.MissionRepository
import request.mission.CreateMissionRequest
import javax.inject.Inject

class CreateMissionUseCase @Inject constructor(
    private val missionRepository: MissionRepository
) {
    suspend operator fun invoke(body: CreateMissionRequest) = runCatching {
        missionRepository.createMission(body = body)
    }
}