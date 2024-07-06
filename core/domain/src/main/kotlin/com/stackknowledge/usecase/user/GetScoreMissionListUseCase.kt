package com.stackknowledge.usecase.user

import com.stackknowledge.repository.user.UserRepository
import javax.inject.Inject

class GetScoreMissionListUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke() =
        userRepository.getSolvedMission()
}