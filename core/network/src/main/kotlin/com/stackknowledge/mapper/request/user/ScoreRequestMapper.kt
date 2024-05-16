package com.stackknowledge.mapper.request.user

import com.stackknowledge.dto.request.user.ScoreRequest
import remote.request.user.ScoreRequestModel

fun ScoreRequestModel.toDto(): ScoreRequest =
    ScoreRequest(
        solveStatus = this.solveStatus
    )