package com.stackknowledge.usecase.student

import com.stackknowledge.repository.student.StudentRepository
import kotlinx.coroutines.flow.Flow
import remote.response.student.GetMyInformationResponseModel
import remote.response.student.GetStudentPointRankingResponseModel
import javax.inject.Inject

class GetMyInformationUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    operator fun invoke(): Flow<GetMyInformationResponseModel> =
        studentRepository.getMyInformation()
}