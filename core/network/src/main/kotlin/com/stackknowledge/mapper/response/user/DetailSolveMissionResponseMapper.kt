package com.stackknowledge.mapper.response.user

import com.stackknowledge.dto.response.user.DetailSolveMissionResponse
import remote.response.user.DetailSolveMissionResponseModel

fun DetailSolveMissionResponse.toModel(): DetailSolveMissionResponseModel =
    DetailSolveMissionResponseModel(
        solveId = this.solveId,
        title = this.title,
        solution = this.solution,
    )