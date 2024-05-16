package com.stackknowledge.repository.user

import com.stackknowledge.dto.request.user.ApproveRequest
import com.stackknowledge.dto.request.user.ScoreRequest
import com.stackknowledge.dto.response.user.DetailSolveMissionResponse
import com.stackknowledge.dto.response.user.GetRequestSignUpTeacherResponse
import com.stackknowledge.dto.response.user.GetSolveMissionResponse
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface UserRepository {
    fun getSolvedMission(): Flow<List<GetSolveMissionResponse>>

    fun getDetailSolveMission(solveId: UUID): Flow<DetailSolveMissionResponse>

    fun getRequestSignUpTeacher(): Flow<List<GetRequestSignUpTeacherResponse>>

    fun scoreSolveMission(solveId: UUID, body: ScoreRequest): Flow<Unit>

    fun signUpApprove(userId: UUID, body: ApproveRequest): Flow<Unit>
}