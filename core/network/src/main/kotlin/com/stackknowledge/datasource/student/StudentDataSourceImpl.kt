package com.stackknowledge.datasource.student

import com.stackknowledge.api.StudentAPI
import kotlinx.coroutines.flow.Flow
import remote.request.student.UploadProfileImageRequest
import remote.response.student.GetMyInformationResponse
import remote.response.student.GetStudentPointRankingResponse
import remote.response.student.UploadProfileImageResponse
import javax.inject.Inject

class StudentDataSourceImpl @Inject constructor(
    private val studentAPI: StudentAPI
) : StudentDataSource {
    override suspend fun getStudentPointRanking(): Flow<List<GetStudentPointRankingResponse>> {
        TODO()
    }

    override suspend fun getMyInformation(): Flow<GetMyInformationResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun uploadProfileImage(body: UploadProfileImageRequest): Flow<UploadProfileImageResponse> {
        TODO("Not yet implemented")
    }
}