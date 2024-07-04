package com.stackknowledge.usecase.user

import com.stackknowledge.repository.user.UserRepository
import java.util.UUID
import javax.inject.Inject

class DetailScoreMissionUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(solveId: String) =
        userRepository.getDetailSolveMission(solveId = solveId)
}