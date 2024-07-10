package com.stackknowledge.datasource.mission

import com.stackknowledge.dto.request.mission.CreateMissionRequest
import com.stackknowledge.dto.response.mission.DetailMissionResponse
import com.stackknowledge.dto.response.mission.MissionResponse
import kotlinx.coroutines.flow.Flow

interface MissionDataSource {
    fun getMission(): Flow<List<MissionResponse>>

    fun detailMission(missionId: String): Flow<DetailMissionResponse>

    fun createMission(body: CreateMissionRequest): Flow<Unit>
}