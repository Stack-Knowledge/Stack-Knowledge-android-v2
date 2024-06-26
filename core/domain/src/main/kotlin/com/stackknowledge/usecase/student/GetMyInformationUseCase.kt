package com.stackknowledge.usecase.student

import com.stackknowledge.repository.student.StudentRepository
import javax.inject.Inject

class GetMyInformationUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    operator fun invoke() {
        studentRepository.getMyInformation()
    }
}