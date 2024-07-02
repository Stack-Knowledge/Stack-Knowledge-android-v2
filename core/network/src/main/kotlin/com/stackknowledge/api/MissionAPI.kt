package com.stackknowledge.api

import com.stackknowledge.dto.request.mission.CreateMissionRequest
import com.stackknowledge.dto.request.mission.DetailMissionRequest
import com.stackknowledge.dto.response.mission.DetailMissionResponse
import com.stackknowledge.dto.response.mission.MissionResponse
import remote.request.mission.CreateMissionRequestModel
import remote.request.mission.DetailMissionRequestModel
import remote.response.mission.DetailMissionResponseModel
import remote.response.mission.MissionResponseModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MissionAPI {
    @GET("/mission")
    suspend fun getMission(): List<MissionResponse>

    @GET("/mission/{mission_id}")
    suspend fun getDetailMission(
        @Path("mission_id") missionId: DetailMissionRequest,
    ): DetailMissionResponse

    @POST("/mission")
    suspend fun createMission(
        @Body body: CreateMissionRequest,
    )
}