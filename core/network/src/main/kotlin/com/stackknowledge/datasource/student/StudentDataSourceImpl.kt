package com.stackknowledge.datasource.student

import com.stackknowledge.api.StudentAPI
import com.stackknowledge.dto.response.student.GetMyInformationResponse
import com.stackknowledge.dto.response.student.GetStudentPointRankingResponse
import com.stackknowledge.dto.response.student.UploadProfileImageResponse
import com.stackknowledge.util.StackKnowledgeApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MultipartBody
import javax.inject.Inject

class StudentDataSourceImpl @Inject constructor(
    private val studentAPI: StudentAPI,
) : StudentDataSource {
    override fun getStudentPointRanking(): Flow<List<GetStudentPointRankingResponse>> =
        flow {
            emit(
                StackKnowledgeApiHandler<List<GetStudentPointRankingResponse>>()
                    .httpRequest { studentAPI.getStudentPointRanking() }
                    .sendRequest()
            )
        }.flowOn(Dispatchers.IO)

    override fun getMyInformation(): Flow<GetMyInformationResponse> = flow {
        emit(
            StackKnowledgeApiHandler<GetMyInformationResponse>()
                .httpRequest { studentAPI.getMyInformation() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override fun uploadProfileImage(image: MultipartBody.Part): Flow<UploadProfileImageResponse> = flow {
        emit(
            StackKnowledgeApiHandler<UploadProfileImageResponse>()
                .httpRequest { studentAPI.uploadProfileImage(image = image) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}