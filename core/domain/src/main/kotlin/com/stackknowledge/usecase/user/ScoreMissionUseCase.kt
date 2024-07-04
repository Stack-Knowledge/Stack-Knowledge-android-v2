package com.stackknowledge.usecase.user

import com.stackknowledge.repository.user.UserRepository
import remote.request.user.ScoreRequestModel
import java.util.UUID
import javax.inject.Inject

class ScoreMissionUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(solveId: UUID, body: ScoreRequestModel) =
        userRepository.scoreSolveMission(solveId = solveId, body = body)
}