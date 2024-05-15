package com.stackknowledge.repository

import kotlinx.coroutines.flow.Flow
import remote.request.student.UploadProfileImageRequest
import remote.response.student.GetMyInformationResponse
import remote.response.student.GetStudentPointRankingResponse
import remote.response.student.UploadProfileImageResponse

interface StudentRepository {
    suspend fun getStudentPointRaking() : Flow<List<GetStudentPointRankingResponse>>
    suspend fun getMyInformation(): Flow<GetMyInformationResponse>
    suspend fun uploadProfileImage(body: UploadProfileImageRequest): Flow<UploadProfileImageResponse>
}