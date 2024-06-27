package com.stackknowledge.mapper.request.solve

import com.stackknowledge.dto.request.solve.SolveRequest
import remote.request.solve.SolveRequestModel

fun SolveRequestModel.toDto(): SolveRequest =
    SolveRequest(
        solution = this.solution,
    )