package com.stackknowledge.datasource.mission

import android.util.Log
import com.stackknowledge.api.MissionAPI
import com.stackknowledge.dto.request.mission.CreateMissionRequest
import com.stackknowledge.dto.response.mission.DetailMissionResponse
import com.stackknowledge.dto.response.mission.MissionResponse
import com.stackknowledge.util.StackKnowledgeApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MissionDataSourceImpl @Inject constructor(
    private val missionAPI: MissionAPI
) : MissionDataSource {
    override fun getMission(): Flow<List<MissionResponse>> = flow {
        emit(
            StackKnowledgeApiHandler<List<MissionResponse>>()
                .httpRequest { missionAPI.getMission() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override fun detailMission(missionId: String): Flow<DetailMissionResponse> = flow {
        emit(
            StackKnowledgeApiHandler<DetailMissionResponse>()
                .httpRequest { missionAPI.getDetailMission(missionId = missionId) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override fun createMission(body: CreateMissionRequest): Flow<Unit> = flow {
        emit(
            StackKnowledgeApiHandler<Unit>()
                .httpRequest { missionAPI.createMission(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}