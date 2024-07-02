package com.stackknowledge.datasource.mission

import android.util.Log
import com.stackknowledge.api.MissionAPI
import com.stackknowledge.dto.request.mission.CreateMissionRequest
import com.stackknowledge.dto.request.mission.DetailMissionRequest
import com.stackknowledge.dto.response.mission.DetailMissionResponse
import com.stackknowledge.dto.response.mission.MissionResponse
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
    override fun getMission(): Flow<List<MissionResponse>> = flow {
        Log.e("getMissionDataSource", "Success")
        emit(
            StackKnowledgeApiHandler<List<MissionResponse>>()
                .httpRequest { missionAPI.getMission() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override fun detailMission(missionId: DetailMissionRequest): Flow<DetailMissionResponse> = flow {
        emit(
            StackKnowledgeApiHandler<DetailMissionResponse>()
                .httpRequest { missionAPI.getDetailMission(missionId = missionId) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override fun createMission(body: CreateMissionRequest): Flow<Unit> = flow {
        Log.e("createMissionDataSource", "Success")
        emit(
            StackKnowledgeApiHandler<Unit>()
                .httpRequest { missionAPI.createMission(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}