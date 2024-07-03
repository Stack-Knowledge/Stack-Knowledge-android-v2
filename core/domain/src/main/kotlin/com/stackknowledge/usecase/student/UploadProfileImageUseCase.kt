package com.stackknowledge.usecase.student

import com.stackknowledge.repository.student.StudentRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class UploadProfileImageUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    operator fun invoke(image: MultipartBody.Part) {
        studentRepository.uploadProfileImage(
            image = image
        )
    }
}