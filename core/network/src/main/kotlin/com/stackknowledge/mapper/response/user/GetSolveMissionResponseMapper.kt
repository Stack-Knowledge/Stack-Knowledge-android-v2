package com.stackknowledge.mapper.response.user

import com.stackknowledge.dto.response.user.GetSolveMissionResponse
import com.stackknowledge.mapper.user.toModel
import remote.response.user.GetSolveMissionResponseModel

fun GetSolveMissionResponse.toModel(): GetSolveMissionResponseModel =
    GetSolveMissionResponseModel(
        response = this.response.map { it.toModel() }
    )