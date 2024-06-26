package com.stackknowledge.datasource.mission

import kotlinx.coroutines.flow.Flow
import remote.request.mission.CreateMissionRequestModel
import remote.request.mission.DetailMissionRequestModel
import remote.response.mission.DetailMissionResponseModel
import remote.response.mission.MissionResponseModel

interface MissionDataSource {
    fun getMission(): Flow<MissionResponseModel>

    fun detailMission(missionId: DetailMissionRequestModel): Flow<DetailMissionResponseModel>

    fun createMission(body: CreateMissionRequestModel): Flow<Unit>
}