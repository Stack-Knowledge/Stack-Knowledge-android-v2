package com.stackknowledge.api

import request.mission.CreateMissionRequest
import request.mission.DetailMissionRequest
import response.mission.DetailMissionResponse
import response.mission.MissionResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MissionAPI {
    @GET("/mission")
    suspend fun getMission(): MissionResponse

    @GET("/mission/{mission_id}")
    suspend fun getDetailMission(
        @Path("mission_id") missionId: DetailMissionRequest,
    ): DetailMissionResponse

    @POST("/mission")
    suspend fun createMission(
        @Body body: CreateMissionRequest
    )
}