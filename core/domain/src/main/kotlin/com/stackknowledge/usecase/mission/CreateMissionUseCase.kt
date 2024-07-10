package com.stackknowledge.usecase.mission

import com.stackknowledge.repository.mission.MissionRepository
import remote.request.mission.CreateMissionRequestModel
import javax.inject.Inject

class CreateMissionUseCase @Inject constructor(
    private val missionRepository: MissionRepository
) {
    operator fun invoke(body: CreateMissionRequestModel) = kotlin.runCatching {
        missionRepository.createMission(body = body)
    }
}