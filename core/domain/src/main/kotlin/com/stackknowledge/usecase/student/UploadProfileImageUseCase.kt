package com.stackknowledge.usecase.student

import com.stackknowledge.repository.StudentRepository
import remote.request.student.UploadProfileImageRequest
import javax.inject.Inject

class UploadProfileImageUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    operator fun invoke(body: UploadProfileImageRequest) {
        studentRepository.uploadProfileImage(
            body = body
        )
    }
}