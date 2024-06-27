package com.stackknowledge.api

import com.stackknowledge.dto.request.solve.SolveRequest
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.UUID

interface SolveAPI {
    @POST("/solve/{mission_id}")
    suspend fun solveMission(
        @Path ("mission_id") missionId: UUID,
        @Body solution: SolveRequest,
    )
}