package com.stackknowledge.repository.mission

import android.util.Log
import com.stackknowledge.datasource.mission.MissionDataSource
import com.stackknowledge.mapper.request.mission.toDto
import com.stackknowledge.mapper.response.mission.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import remote.request.mission.CreateMissionRequestModel
import remote.request.mission.DetailMissionRequestModel
import remote.response.mission.DetailMissionResponseModel
import remote.response.mission.MissionResponseModel
import javax.inject.Inject

class MissionRepositoryImpl @Inject constructor(
    private val missionDataSource: MissionDataSource
) : MissionRepository {
    override fun getMission(): Flow<List<MissionResponseModel>> {
        Log.e("getMissionRepository", "Success")
        return missionDataSource.getMission().map { list -> list.map { it.toModel() } }
    }

    override fun detailMission(missionId: DetailMissionRequestModel): Flow<DetailMissionResponseModel> {
        return missionDataSource.detailMission(missionId = missionId.toDto()).map { it.toModel() }
    }

    override fun createMission(body: CreateMissionRequestModel): Flow<Unit> {
        Log.e("createMissionRepository", "Success")
        return missionDataSource.createMission(body = body.toDto())
    }
}