package com.stackknowledge.misson

import com.stackknowledge.repository.mission.MissionRepository
import javax.inject.Inject

class GetMissionUseCase @Inject constructor(
    private val missionRepository: MissionRepository
) {
    suspend operator fun invoke() = runCatching {
        missionRepository.getMission()
    }
}