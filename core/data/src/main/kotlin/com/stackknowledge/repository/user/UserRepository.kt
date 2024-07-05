package com.stackknowledge.repository.user

import kotlinx.coroutines.flow.Flow
import remote.request.user.ApproveRequestModel
import remote.request.user.ScoreRequestModel
import remote.response.user.DetailSolveMissionResponseModel
import remote.response.user.GetRequestSignUpTeacherResponseModel
import remote.response.user.GetSolveMissionResponseModel
import java.util.UUID

interface UserRepository {
    fun getSolvedMission(): Flow<GetSolveMissionResponseModel>

    fun getDetailSolveMission(solveId: String): Flow<DetailSolveMissionResponseModel>

    fun getRequestSignUpTeacher(): Flow<List<GetRequestSignUpTeacherResponseModel>>

    fun scoreSolveMission(solveId: String, body: ScoreRequestModel): Flow<Unit>

    fun signUpApprove(userId: UUID, body: ApproveRequestModel): Flow<Unit>
}