package com.stackknowledge.datasource.student

import remote.response.student.GetStudentPointRankingResponse
import kotlinx.coroutines.flow.Flow
import remote.request.student.UploadProfileImageRequest
import remote.response.student.GetMyInformationResponse
import remote.response.student.UploadProfileImageResponse

interface StudentDataSource {
    fun getStudentPointRanking(): Flow<List<GetStudentPointRankingResponse>>
    fun getMyInformation(): Flow<GetMyInformationResponse>
    fun uploadProfileImage(body: UploadProfileImageRequest): Flow<UploadProfileImageResponse>
}