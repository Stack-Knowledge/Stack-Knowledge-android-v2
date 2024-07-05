package com.stackknowledge.mapper.response.student

import com.stackknowledge.dto.response.student.GetMyInformationResponse
import com.stackknowledge.mapper.user.toModel
import remote.response.student.GetMyInformationResponseModel

fun GetMyInformationResponse.toModel(): GetMyInformationResponseModel =
    GetMyInformationResponseModel(
        id = this.id,
        currentPoint = this.currentPoint,
        cumulatePoint = this.cumulatePoint,
        user = this.user.toModel()
    )