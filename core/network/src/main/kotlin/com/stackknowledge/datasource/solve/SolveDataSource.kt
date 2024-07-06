package com.stackknowledge.datasource.solve

import com.stackknowledge.dto.request.solve.SolveRequest
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface SolveDataSource {
    fun solveMission(missionId: String, solution: SolveRequest): Flow<Unit>
}