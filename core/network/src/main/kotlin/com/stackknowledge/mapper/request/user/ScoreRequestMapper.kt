package com.stackknowledge.mapper.request.user

import com.stackknowledge.dto.request.user.ScoreRequest
import remote.request.user.ScoreRequestModel

fun ScoreRequest.toModel(): ScoreRequestModel =
    ScoreRequestModel(
        solveStatus = this.solveStatus
    )