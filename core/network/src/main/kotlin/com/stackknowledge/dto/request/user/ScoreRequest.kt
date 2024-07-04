package com.stackknowledge.dto.request.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import enumdatatype.SolveStatus

@JsonClass(generateAdapter = true)
data class ScoreRequest(
    @Json(name = "solveStatus") val solveStatus: SolveStatus,
)