package com.stackknowledge.mapper.response

import com.stackknowledge.dto.response.user.DetailSolveMissionResponse
import remote.response.user.DetailSolveMissionResponseModel

fun DetailSolveMissionResponse.toModel(): DetailSolveMissionResponseModel =
    DetailSolveMissionResponseModel(
        solveId = this.solveId,
        title = this.title,
        solution = this.solution,
    )