package com.stackknowledge.usecase.misson

import com.stackknowledge.repository.mission.MissionRepository
import remote.request.mission.DetailMissionRequestModel
import javax.inject.Inject

class DetailMissionUseCase @Inject constructor(
    private val missionRepository: MissionRepository
) {
    operator fun invoke(missionId: DetailMissionRequestModel) = runCatching {
        missionRepository.detailMission(missionId = missionId)
    }
}