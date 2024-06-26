package com.stackknowledge.repository.mission

import com.stackknowledge.datasource.mission.MissionDataSource
import kotlinx.coroutines.flow.Flow
import request.mission.CreateMissionRequest
import request.mission.DetailMissionRequest
import response.mission.DetailMissionResponse
import response.mission.MissionResponse
import javax.inject.Inject

class MissionRepositoryImpl @Inject constructor(
    private val missionDataSource: MissionDataSource
): MissionRepository {
    override suspend fun getMission(): Flow<MissionResponse> {
        return missionDataSource.getMission()
    }

    override suspend fun detailMission(missionId: DetailMissionRequest): Flow<DetailMissionResponse> {
        return missionDataSource.detailMission(missionId = missionId)
    }

    override suspend fun createMission(body: CreateMissionRequest): Flow<Unit> {
        return missionDataSource.createMission(body = body)
    }
}