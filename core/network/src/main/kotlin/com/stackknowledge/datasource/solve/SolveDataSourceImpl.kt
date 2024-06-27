package com.stackknowledge.datasource.solve

import com.stackknowledge.api.SolveAPI
import com.stackknowledge.dto.request.solve.SolveRequest
import com.stackknowledge.util.StackKnowledgeApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.UUID
import javax.inject.Inject

class SolveDataSourceImpl @Inject constructor(
    private val solveAPI: SolveAPI
): SolveDataSource {
    override fun solveMission(missionId: UUID, solution: SolveRequest): Flow<Unit> = flow {
        emit(
            StackKnowledgeApiHandler<Unit>()
                .httpRequest { solveAPI.solveMission(missionId = missionId, solution = solution) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}