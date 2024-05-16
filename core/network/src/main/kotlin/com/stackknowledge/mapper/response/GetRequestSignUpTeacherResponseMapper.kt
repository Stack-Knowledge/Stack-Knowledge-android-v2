package com.stackknowledge.mapper.response

import com.stackknowledge.dto.response.user.GetRequestSignUpTeacherResponse
import remote.response.user.GetRequestSignUpTeacherResponseModel

fun GetRequestSignUpTeacherResponse.toModel(): GetRequestSignUpTeacherResponseModel =
    GetRequestSignUpTeacherResponseModel(
        userId = this.userId,
        name = this.name,
        createdAt = this.createdAt,
    )