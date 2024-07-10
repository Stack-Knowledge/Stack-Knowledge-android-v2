package com.stackknowledge.usecase.solve

import com.stackknowledge.repository.solve.SolveRepository
import remote.request.solve.SolveRequestModel
import java.util.UUID
import javax.inject.Inject

class SolveUseCase @Inject constructor(
    private val solveRepository: SolveRepository
) {
    operator fun invoke(missionId: String, solution: SolveRequestModel) = kotlin.runCatching {
        solveRepository.solveMission(missionId = missionId, solution = solution)
    }
}