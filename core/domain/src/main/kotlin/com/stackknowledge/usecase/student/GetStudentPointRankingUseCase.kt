package com.stackknowledge.usecase.student

import com.stackknowledge.repository.StudentRepository
import javax.inject.Inject

class GetStudentPointRankingUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    operator fun invoke() {
        studentRepository.getStudentPointRaking()
    }
}