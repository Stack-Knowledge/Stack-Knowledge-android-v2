package com.stackknowledge.dto.response.mission

import com.stackknowledge.dto.user.User
import enumdata.MissionStatus
import java.util.UUID

data class GetMissionListResponse(
    val id: UUID,
    val title: String,
    val point: Int,
    val missionStatus: MissionStatus,
    val user: User,
) {
    data class User(
        val id: UUID,
        val name: String,
        val profileImage: String?,
    )
}
