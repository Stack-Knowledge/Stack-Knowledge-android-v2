package com.stackknowledge.repository.user

import com.stackknowledge.datasource.user.UserDataSource
import com.stackknowledge.mapper.request.user.toDto
import com.stackknowledge.mapper.response.user.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import remote.request.user.ApproveRequestModel
import remote.request.user.ScoreRequestModel
import remote.response.user.DetailSolveMissionResponseModel
import remote.response.user.GetRequestSignUpTeacherResponseModel
import remote.response.user.GetSolveMissionListModel
import remote.response.user.GetSolveMissionResponseModel
import java.util.UUID
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : UserRepository {
    override fun getSolvedMission(): Flow<GetSolveMissionResponseModel> {
        return userDataSource.getSolvedMission().map { it.toModel() }
    }

    override fun getDetailSolveMission(solveId: String): Flow<DetailSolveMissionResponseModel> {
        return userDataSource.getDetailSolveMission(solveId = solveId).map { it.toModel() }
    }

    override fun getRequestSignUpTeacher(): Flow<List<GetRequestSignUpTeacherResponseModel>> {
        return userDataSource.getRequestSignUpTeacher().map { list -> list.map { it.toModel() } }
    }

    override fun scoreSolveMission(solveId: String, body: ScoreRequestModel): Flow<Unit> {
        return userDataSource.scoreSolveMission(
            solveId = solveId,
            body = body.toDto(),
        )
    }

    override fun signUpApprove(userId: UUID, body: ApproveRequestModel): Flow<Unit> {
        return userDataSource.signUpApprove(
            userId = userId,
            body = body.toDto(),
        )
    }
}