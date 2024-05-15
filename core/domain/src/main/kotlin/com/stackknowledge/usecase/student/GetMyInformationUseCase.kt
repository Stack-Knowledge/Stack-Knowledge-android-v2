package com.stackknowledge.usecase.student

import com.stackknowledge.repository.StudentRepository
import javax.inject.Inject

class GetMyInformationUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    suspend operator fun invoke() = runCatching {
        studentRepository.getMyInformation()
    }
}