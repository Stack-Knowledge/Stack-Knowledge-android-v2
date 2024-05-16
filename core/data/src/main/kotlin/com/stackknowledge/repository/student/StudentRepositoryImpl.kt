package com.stackknowledge.repository.student

import com.stackknowledge.datasource.student.StudentDataSource
import kotlinx.coroutines.flow.Flow
import remote.request.student.UploadProfileImageRequest
import remote.response.student.GetMyInformationResponse
import remote.response.student.GetStudentPointRankingResponse
import remote.response.student.UploadProfileImageResponse
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val studentDataSource: StudentDataSource,
) : StudentRepository {
    override fun getStudentPointRaking(): Flow<List<GetStudentPointRankingResponse>> {
        return studentDataSource.getStudentPointRanking()
    }

    override fun getMyInformation(): Flow<GetMyInformationResponse> {
        return studentDataSource.getMyInformation()
    }

    override fun uploadProfileImage(body: UploadProfileImageRequest): Flow<UploadProfileImageResponse> {
        return studentDataSource.uploadProfileImage(
            body = body
        )
    }
}