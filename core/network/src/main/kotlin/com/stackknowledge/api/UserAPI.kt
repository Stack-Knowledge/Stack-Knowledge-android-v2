package com.stackknowledge.api

import com.stackknowledge.dto.request.user.ScoreRequest
import com.stackknowledge.dto.response.user.DetailSolveMissionResponse
import com.stackknowledge.dto.response.user.GetSolveMissionResponse
import retrofit2.http.Body
import retrofit2.http.GET
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
}