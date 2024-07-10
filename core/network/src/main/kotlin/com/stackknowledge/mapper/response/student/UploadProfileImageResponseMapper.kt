package com.stackknowledge.mapper.response.student

import com.stackknowledge.dto.response.student.UploadProfileImageResponse
import remote.response.student.UploadProfileImageResponseModel

fun UploadProfileImageResponse.toModel(): UploadProfileImageResponseModel =
    UploadProfileImageResponseModel(
        fileName = this.fileName
    )