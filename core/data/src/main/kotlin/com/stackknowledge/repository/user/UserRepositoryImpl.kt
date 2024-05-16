package com.stackknowledge.repository.user

import com.stackknowledge.datasource.user.UserDataSource
import com.stackknowledge.dto.request.user.ApproveRequest
import com.stackknowledge.dto.request.user.ScoreRequest
import com.stackknowledge.dto.response.user.DetailSolveMissionResponse
import com.stackknowledge.dto.response.user.GetRequestSignUpTeacherResponse
import com.stackknowledge.dto.response.user.GetSolveMissionResponse
import kotlinx.coroutines.flow.Flow
import java.util.UUID
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : UserRepository {
    override fun getSolvedMission(): Flow<List<GetSolveMissionResponse>> {
        return userDataSource.getSolvedMission()
    }

    override fun getDetailSolveMission(solveId: UUID): Flow<DetailSolveMissionResponse> {
        return userDataSource.getDetailSolveMission(solveId = solveId)
    }

    override fun getRequestSignUpTeacher(): Flow<List<GetRequestSignUpTeacherResponse>> {
        return userDataSource.getRequestSignUpTeacher()
    }

    override fun scoreSolveMission(solveId: UUID, body: ScoreRequest): Flow<Unit> {
        return userDataSource.scoreSolveMission(
            solveId = solveId,
            body = body
        )
    }

    override fun signUpApprove(userId: UUID, body: ApproveRequest): Flow<Unit> {
        return userDataSource.signUpApprove(
            userId = userId,
            body = body
        )
    }
}