package com.stackknowledge.usecase.mission

import com.stackknowledge.repository.mission.MissionRepository
import javax.inject.Inject

class DetailMissionUseCase @Inject constructor(
    private val missionRepository: MissionRepository
) {
    operator fun invoke(missionId: String) =
        missionRepository.detailMission(missionId = missionId)
}