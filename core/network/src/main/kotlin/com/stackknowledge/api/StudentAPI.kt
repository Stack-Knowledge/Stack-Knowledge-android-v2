package com.stackknowledge.api

import remote.request.student.UploadProfileImageRequest
import remote.response.student.GetMyInformationResponse
import remote.response.student.GetStudentPointRankingResponse
import remote.response.student.UploadProfileImageResponse
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
        @Body body: UploadProfileImageRequest
    ): UploadProfileImageResponse
}