package com.stackknowledge.usecase.student

import com.stackknowledge.repository.StudentRepository
import remote.request.student.UploadProfileImageRequest
import javax.inject.Inject

class UploadProfileImageUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    suspend operator fun invoke(body: UploadProfileImageRequest) = runCatching {
        studentRepository.uploadProfileImage(
            body = body
        )
    }
}