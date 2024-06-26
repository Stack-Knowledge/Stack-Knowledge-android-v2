package com.stackknowledge.datasource.mission

import com.stackknowledge.api.MissionAPI
import com.stackknowledge.util.StackKnowledgeApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import remote.request.mission.CreateMissionRequestModel
import remote.request.mission.DetailMissionRequestModel
import remote.response.mission.DetailMissionResponseModel
import remote.response.mission.MissionResponseModel
import javax.inject.Inject

class MissionDataSourceImpl @Inject constructor(
    private val missionAPI: MissionAPI
) : MissionDataSource {
    override suspend fun getMission(): Flow<MissionResponseModel> = flow {
        emit(
            StackKnowledgeApiHandler<MissionResponseModel>()
                .httpRequest { missionAPI.getMission() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun detailMission(missionId: DetailMissionRequestModel): Flow<DetailMissionResponseModel> = flow {
        emit(
            StackKnowledgeApiHandler<DetailMissionResponseModel>()
                .httpRequest { missionAPI.getDetailMission(missionId = missionId) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun createMission(body: CreateMissionRequestModel): Flow<Unit> = flow {
        emit(
            StackKnowledgeApiHandler<Unit>()
                .httpRequest { missionAPI.createMission(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}