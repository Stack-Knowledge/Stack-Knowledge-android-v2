package com.stackknowledge.datasource.user

import com.stackknowledge.api.UserAPI
import com.stackknowledge.dto.request.user.ApproveRequest
import com.stackknowledge.dto.request.user.ScoreRequest
import com.stackknowledge.dto.response.user.DetailSolveMissionResponse
import com.stackknowledge.dto.response.user.GetRequestSignUpTeacherResponse
import com.stackknowledge.dto.response.user.GetSolveMissionResponse
import com.stackknowledge.util.StackKnowledgeApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.UUID
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val userAPI: UserAPI
) : UserDataSource {
    override fun getSolvedMission(): Flow<List<GetSolveMissionResponse>> = flow {
        emit(
            StackKnowledgeApiHandler<List<GetSolveMissionResponse>>()
                .httpRequest { userAPI.getSolvedMission() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override fun getDetailSolveMission(solveId: UUID): Flow<DetailSolveMissionResponse> = flow {
        emit(
            StackKnowledgeApiHandler<DetailSolveMissionResponse>()
                .httpRequest { userAPI.getDetailSolveMission(solveId = solveId) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override fun getRequestSignUpTeacher(): Flow<List<GetRequestSignUpTeacherResponse>> = flow {
        emit(
            StackKnowledgeApiHandler<List<GetRequestSignUpTeacherResponse>>()
                .httpRequest { userAPI.getRequestSignUpTeacher() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override fun scoreSolveMission(solveId: UUID, body: ScoreRequest): Flow<Unit> = flow {
        emit(
            StackKnowledgeApiHandler<Unit>()
                .httpRequest { userAPI.scoreSolveMission(solveId = solveId, body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override fun signUpApprove(userId: UUID, body: ApproveRequest): Flow<Unit> = flow {
        emit(
            StackKnowledgeApiHandler<Unit>()
                .httpRequest { userAPI.signUpApprove(userId = userId, body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

}