package com.stackknowledge.api

import com.stackknowledge.dto.response.student.GetMyInformationResponse
import com.stackknowledge.dto.response.student.GetStudentPointRankingResponse
import com.stackknowledge.dto.response.student.UploadProfileImageResponse
import okhttp3.MultipartBody
import remote.response.student.GetMyInformationResponseModel
import remote.response.student.GetStudentPointRankingResponseModel
import remote.response.student.UploadProfileImageResponseModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface StudentAPI {
    @GET("student/ranking")
    suspend fun getStudentPointRanking(): List<GetStudentPointRankingResponse>

    @GET("student/my")
    suspend fun getMyInformation(): GetMyInformationResponse

    @POST("student/image")
    suspend fun uploadProfileImage(
        @Body image: MultipartBody.Part
    ): UploadProfileImageResponse
}