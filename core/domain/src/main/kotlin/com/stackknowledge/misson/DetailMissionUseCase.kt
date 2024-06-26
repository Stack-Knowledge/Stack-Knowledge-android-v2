package com.stackknowledge.misson

import com.stackknowledge.repository.mission.MissionRepository
import request.mission.DetailMissionRequest
import javax.inject.Inject

class DetailMissionUseCase @Inject constructor(
    private val missionRepository: MissionRepository
) {
    suspend operator fun invoke(missionId: DetailMissionRequest) = runCatching {
        missionRepository.detailMission(missionId = missionId)
    }
}