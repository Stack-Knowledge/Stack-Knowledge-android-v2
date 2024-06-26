package com.stackknowledge.api

<<<<<<< HEAD
import remote.request.mission.CreateMissionRequestModel
import remote.request.mission.DetailMissionRequestModel
import remote.response.mission.DetailMissionResponseModel
import remote.response.mission.MissionResponseModel
=======
import com.stackknowledge.dto.request.mission.CreateMissionRequest
import com.stackknowledge.dto.response.mission.GetMissionListResponse
>>>>>>> origin/feature/#46_mission_domain_network_setting
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
<<<<<<< HEAD

interface MissionAPI {
    @GET("/mission")
    suspend fun getMission(): MissionResponseModel

    @GET("/mission/{mission_id}")
    suspend fun getDetailMission(
        @Path("mission_id") missionId: DetailMissionRequestModel,
    ): DetailMissionResponseModel

    @POST("/mission")
    suspend fun createMission(
        @Body body: CreateMissionRequestModel
=======
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
>>>>>>> origin/feature/#46_mission_domain_network_setting
    )
}