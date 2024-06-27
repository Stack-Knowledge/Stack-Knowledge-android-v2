package com.stackknowledge.repository.solve

import com.stackknowledge.datasource.solve.SolveDataSource
import com.stackknowledge.mapper.request.solve.toDto
import kotlinx.coroutines.flow.Flow
import remote.request.solve.SolveRequestModel
import java.util.UUID
import javax.inject.Inject

class SolveRepositoryImpl @Inject constructor(
    private val solveDataSource: SolveDataSource
): SolveRepository {
    override fun solveMission(missionId: UUID, solution: SolveRequestModel): Flow<Unit> {
        return solveDataSource.solveMission(missionId = missionId, solution = solution.toDto())
    }
}