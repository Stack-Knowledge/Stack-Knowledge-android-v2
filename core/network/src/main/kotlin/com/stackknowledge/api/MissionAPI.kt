package com.stackknowledge.api

import com.stackknowledge.dto.request.mission.CreateMissionRequest
import com.stackknowledge.dto.response.mission.GetMissionListResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.UUID

interface MissionAPI {
    @GET("mission")
    suspend fun getMissionList(): List<GetMissionListResponse>

    @GET("mission/{mission_id}")
    suspend fun getMissionDetail(
        @Path("mission_id") missionId: UUID,
    )

    @POST("mission")
    suspend fun createMission(
        @Body body: CreateMissionRequest,
    )
}