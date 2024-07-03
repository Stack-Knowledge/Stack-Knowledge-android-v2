package com.stackknowledge.datasource.student

import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import remote.response.student.GetMyInformationResponse
import remote.response.student.GetStudentPointRankingResponse
import remote.response.student.UploadProfileImageResponse

interface StudentDataSource {
    fun getStudentPointRanking(): Flow<List<GetStudentPointRankingResponse>>
    fun getMyInformation(): Flow<GetMyInformationResponse>
    fun uploadProfileImage(image: MultipartBody.Part): Flow<UploadProfileImageResponse>
}