package com.stackknowledge.datasource.student

import remote.response.student.GetStudentPointRankingResponse
import kotlinx.coroutines.flow.Flow
import remote.request.student.UploadProfileImageRequest
import remote.response.student.GetMyInformationResponse
import remote.response.student.UploadProfileImageResponse

interface StudentDataSource {
    suspend fun getStudentPointRanking(): Flow<List<GetStudentPointRankingResponse>>
    suspend fun getMyInformation(): Flow<GetMyInformationResponse>
    suspend fun uploadProfileImage(body: UploadProfileImageRequest): Flow<UploadProfileImageResponse>
}