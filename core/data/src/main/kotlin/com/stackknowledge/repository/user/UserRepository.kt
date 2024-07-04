package com.stackknowledge.repository.user

import com.stackknowledge.dto.request.user.ApproveRequest
import com.stackknowledge.dto.request.user.ScoreRequest
import com.stackknowledge.dto.response.user.DetailSolveMissionResponse
import com.stackknowledge.dto.response.user.GetRequestSignUpTeacherResponse
import com.stackknowledge.dto.response.user.GetSolveMissionResponse
import kotlinx.coroutines.flow.Flow
import remote.request.user.ApproveRequestModel
import remote.request.user.ScoreRequestModel
import remote.response.user.DetailSolveMissionResponseModel
import remote.response.user.GetRequestSignUpTeacherResponseModel
import remote.response.user.GetSolveMissionResponseModel
import java.util.UUID

interface UserRepository {
    fun getSolvedMission(): Flow<List<GetSolveMissionResponseModel>>

    fun getDetailSolveMission(solveId: String): Flow<DetailSolveMissionResponseModel>

    fun getRequestSignUpTeacher(): Flow<List<GetRequestSignUpTeacherResponseModel>>

    fun scoreSolveMission(solveId: String, body: ScoreRequestModel): Flow<Unit>

    fun signUpApprove(userId: UUID, body: ApproveRequestModel): Flow<Unit>
}