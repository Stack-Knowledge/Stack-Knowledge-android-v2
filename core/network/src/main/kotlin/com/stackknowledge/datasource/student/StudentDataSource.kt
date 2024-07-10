package com.stackknowledge.datasource.student

import com.stackknowledge.dto.response.student.GetMyInformationResponse
import com.stackknowledge.dto.response.student.GetStudentPointRankingResponse
import com.stackknowledge.dto.response.student.UploadProfileImageResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import remote.response.student.GetMyInformationResponseModel
import remote.response.student.GetStudentPointRankingResponseModel
import remote.response.student.UploadProfileImageResponseModel

interface StudentDataSource {
    fun getStudentPointRanking(): Flow<List<GetStudentPointRankingResponse>>
    fun getMyInformation(): Flow<GetMyInformationResponse>
    fun uploadProfileImage(image: MultipartBody.Part): Flow<UploadProfileImageResponse>
}