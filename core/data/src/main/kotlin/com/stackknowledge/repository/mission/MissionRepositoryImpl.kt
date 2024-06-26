package com.stackknowledge.repository.mission

import com.stackknowledge.datasource.mission.MissionDataSource
import kotlinx.coroutines.flow.Flow
import remote.request.mission.CreateMissionRequestModel
import remote.request.mission.DetailMissionRequestModel
import remote.response.mission.DetailMissionResponseModel
import remote.response.mission.MissionResponseModel
import javax.inject.Inject

class MissionRepositoryImpl @Inject constructor(
    private val missionDataSource: MissionDataSource
): MissionRepository {
    override fun getMission(): Flow<MissionResponseModel> {
        return missionDataSource.getMission()
    }

    override fun detailMission(missionId: DetailMissionRequestModel): Flow<DetailMissionResponseModel> {
        return missionDataSource.detailMission(missionId = missionId)
    }

    override fun createMission(body: CreateMissionRequestModel): Flow<Unit> {
        return missionDataSource.createMission(body = body)
    }
}