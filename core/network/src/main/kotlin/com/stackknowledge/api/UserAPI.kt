package com.stackknowledge.api

import com.stackknowledge.dto.request.user.ApproveRequest
import com.stackknowledge.dto.request.user.ScoreRequest
import com.stackknowledge.dto.response.user.DetailSolveMissionResponse
import com.stackknowledge.dto.response.user.GetRequestSignUpTeacherResponse
import com.stackknowledge.dto.response.user.GetSolveMissionResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.UUID

interface UserAPI {
    @GET("/user/scoring")
    suspend fun getSolvedMission(): List<GetSolveMissionResponse>

    @GET("/user/scoring/{solve_id}")
    suspend fun getDetailSolveMission(
        @Path("solve_id") solveId: UUID,
    ): DetailSolveMissionResponse

    @GET("/user/teacher")
    suspend fun getRequestSignUpTeacher(): List<GetRequestSignUpTeacherResponse>

    @POST("/user/scoring/{solve_id}")
    suspend fun scoreSolveMission(
        @Path("solve_id") solveId: UUID,
        @Body body: ScoreRequest,
    )

    @PATCH("/user/{user_id}")
    suspend fun signUpApprove(
        @Path("user_id") userId: UUID,
        @Body body: ApproveRequest
    )
}