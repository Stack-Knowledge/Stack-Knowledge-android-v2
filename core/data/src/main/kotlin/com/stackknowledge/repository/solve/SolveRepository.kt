package com.stackknowledge.repository.solve

import kotlinx.coroutines.flow.Flow
import remote.request.solve.SolveRequestModel
import java.util.UUID

interface SolveRepository {
    fun solveMission(missionId: UUID, solution: SolveRequestModel): Flow<Unit>
}