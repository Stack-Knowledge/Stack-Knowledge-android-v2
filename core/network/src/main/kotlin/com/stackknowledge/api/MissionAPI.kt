package com.stackknowledge.api

import remote.request.mission.CreateMissionRequestModel
import remote.request.mission.DetailMissionRequestModel
import remote.response.mission.DetailMissionResponseModel
import remote.response.mission.MissionResponseModel
import com.stackknowledge.dto.request.mission.CreateMissionRequest
import com.stackknowledge.dto.response.mission.GetMissionListResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MissionAPI {
    @GET("/mission")
    suspend fun getMission(): MissionResponseModel

    @GET("/mission/{mission_id}")
    suspend fun getDetailMission(
        @Path("mission_id") missionId: DetailMissionRequestModel,
    ): DetailMissionResponseModel

    @POST("/mission")
    suspend fun createMission(
        @Body body: CreateMissionRequestModel,
    )
}