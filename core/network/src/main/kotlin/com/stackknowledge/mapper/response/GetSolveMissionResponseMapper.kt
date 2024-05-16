package com.stackknowledge.mapper.response

import com.stackknowledge.dto.response.user.GetSolveMissionResponse
import com.stackknowledge.mapper.user.toModel
import remote.response.user.GetSolveMissionResponseModel

fun GetSolveMissionResponse.toModel(): GetSolveMissionResponseModel =
    GetSolveMissionResponseModel(
        solveId = this.solveId,
        solveStatus = this.solveStatus,
        title = this.title,
        point = this.point,
        user = this.user.toModel(),
    )