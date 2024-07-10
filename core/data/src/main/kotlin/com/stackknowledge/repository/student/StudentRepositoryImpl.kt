package com.stackknowledge.repository.student

import com.stackknowledge.datasource.student.StudentDataSource
import com.stackknowledge.mapper.response.student.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okhttp3.MultipartBody
import remote.response.student.GetMyInformationResponseModel
import remote.response.student.GetStudentPointRankingResponseModel
import remote.response.student.UploadProfileImageResponseModel
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val studentDataSource: StudentDataSource,
) : StudentRepository {
    override fun getStudentPointRaking(): Flow<List<GetStudentPointRankingResponseModel>> {
        return studentDataSource.getStudentPointRanking().map { list -> list.map { it.toModel() } }
    }

    override fun getMyInformation(): Flow<GetMyInformationResponseModel> {
        return studentDataSource.getMyInformation().map { it.toModel() }
    }

    override fun uploadProfileImage(image: MultipartBody.Part): Flow<UploadProfileImageResponseModel> {
        return studentDataSource.uploadProfileImage(
            image = image
        ).map { it.toModel() }
    }
}