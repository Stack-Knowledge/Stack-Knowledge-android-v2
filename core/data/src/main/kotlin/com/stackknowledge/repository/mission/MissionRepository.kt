package com.stackknowledge.repository.mission

import kotlinx.coroutines.flow.Flow
import remote.request.mission.CreateMissionRequestModel
import remote.request.mission.DetailMissionRequestModel
import remote.response.mission.DetailMissionResponseModel
import remote.response.mission.MissionResponseModel

interface MissionRepository {
    suspend fun getMission(): Flow<MissionResponseModel>

    suspend fun detailMission(missionId: DetailMissionRequestModel): Flow<DetailMissionResponseModel>

    suspend fun createMission(body: CreateMissionRequestModel): Flow<Unit>
}