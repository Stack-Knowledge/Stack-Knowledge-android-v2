package com.stackknowledge.usecase.misson

import com.stackknowledge.repository.mission.MissionRepository
import remote.request.mission.CreateMissionRequestModel
import javax.inject.Inject

class CreateMissionUseCase @Inject constructor(
    private val missionRepository: MissionRepository
) {
    operator fun invoke(body: CreateMissionRequestModel) = runCatching {
        missionRepository.createMission(body = body)
    }
}