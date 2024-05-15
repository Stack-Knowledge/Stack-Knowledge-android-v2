package com.stackknowledge.datasource.student

import com.stackknowledge.api.StudentAPI
import com.stackknowledge.util.StackKnowledgeApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import remote.request.student.UploadProfileImageRequest
import remote.response.student.GetMyInformationResponse
import remote.response.student.GetStudentPointRankingResponse
import remote.response.student.UploadProfileImageResponse
import javax.inject.Inject

class StudentDataSourceImpl @Inject constructor(
    private val studentAPI: StudentAPI,
) : StudentDataSource {
    override suspend fun getStudentPointRanking(): Flow<List<GetStudentPointRankingResponse>> =
        flow {
            emit(
                StackKnowledgeApiHandler<List<GetStudentPointRankingResponse>>()
                    .httpRequest { studentAPI.getStudentPointRanking() }
                    .sendRequest()
            )
        }.flowOn(Dispatchers.IO)

    override suspend fun getMyInformation(): Flow<GetMyInformationResponse> = flow {
        emit(
            StackKnowledgeApiHandler<GetMyInformationResponse>()
                .httpRequest { studentAPI.getMyInformation() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun uploadProfileImage(body: UploadProfileImageRequest): Flow<UploadProfileImageResponse> = flow {
        emit(
            StackKnowledgeApiHandler<UploadProfileImageResponse>()
                .httpRequest { studentAPI.uploadProfileImage(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}