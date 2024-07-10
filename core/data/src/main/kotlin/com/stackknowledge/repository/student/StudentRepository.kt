package com.stackknowledge.repository.student

import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import remote.response.student.GetMyInformationResponseModel
import remote.response.student.GetStudentPointRankingResponseModel
import remote.response.student.UploadProfileImageResponseModel

interface StudentRepository {
    fun getStudentPointRaking(): Flow<List<GetStudentPointRankingResponseModel>>
    fun getMyInformation(): Flow<GetMyInformationResponseModel>
    fun uploadProfileImage(image: MultipartBody.Part): Flow<UploadProfileImageResponseModel>
}