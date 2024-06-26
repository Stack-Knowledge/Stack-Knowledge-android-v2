package com.stackknowledge.datasource.mission

import kotlinx.coroutines.flow.Flow
import request.mission.CreateMissionRequest
import request.mission.DetailMissionRequest
import response.mission.DetailMissionResponse
import response.mission.MissionResponse

interface MissionDataSource {
    suspend fun getMission(): Flow<MissionResponse>

    suspend fun detailMission(missionId: DetailMissionRequest): Flow<DetailMissionResponse>

    suspend fun createMission(body: CreateMissionRequest): Flow<Unit>
}