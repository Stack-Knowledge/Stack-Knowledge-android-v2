package com.stackknowledge.repository.student

import kotlinx.coroutines.flow.Flow
import remote.request.student.UploadProfileImageRequest
import remote.response.student.GetMyInformationResponse
import remote.response.student.GetStudentPointRankingResponse
import remote.response.student.UploadProfileImageResponse

interface StudentRepository {
    fun getStudentPointRaking(): Flow<List<GetStudentPointRankingResponse>>
    fun getMyInformation(): Flow<GetMyInformationResponse>
    fun uploadProfileImage(body: UploadProfileImageRequest): Flow<UploadProfileImageResponse>
}