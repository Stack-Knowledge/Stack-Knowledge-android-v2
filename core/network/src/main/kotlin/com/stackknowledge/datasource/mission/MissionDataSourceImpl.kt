package com.stackknowledge.datasource.mission

import com.stackknowledge.api.MissionAPI
import com.stackknowledge.util.StackKnowledgeApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import request.mission.CreateMissionRequest
import request.mission.DetailMissionRequest
import response.mission.DetailMissionResponse
import response.mission.MissionResponse
import javax.inject.Inject

class MissionDataSourceImpl @Inject constructor(
    private val missionAPI: MissionAPI
) : MissionDataSource {
    override suspend fun getMission(): Flow<MissionResponse> = flow {
        emit(
            StackKnowledgeApiHandler<MissionResponse>()
                .httpRequest { missionAPI.getMission() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun detailMission(missionId: DetailMissionRequest): Flow<DetailMissionResponse> = flow {
        emit(
            StackKnowledgeApiHandler<DetailMissionResponse>()
                .httpRequest { missionAPI.getDetailMission(missionId = missionId) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun createMission(body: CreateMissionRequest): Flow<Unit> = flow {
        emit(
            StackKnowledgeApiHandler<Unit>()
                .httpRequest { missionAPI.createMission(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}