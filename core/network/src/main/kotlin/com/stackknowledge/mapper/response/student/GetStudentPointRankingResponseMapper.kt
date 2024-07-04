package com.stackknowledge.mapper.response.student

import com.stackknowledge.dto.response.student.GetStudentPointRankingResponse
import com.stackknowledge.mapper.user.toModel
import remote.response.student.GetStudentPointRankingResponseModel

fun GetStudentPointRankingResponse.toModel(): GetStudentPointRankingResponseModel =
    GetStudentPointRankingResponseModel(
        id = this.id,
        cumulatePoint = this.cumulatePoint,
        user = this.user.toModel()
    )