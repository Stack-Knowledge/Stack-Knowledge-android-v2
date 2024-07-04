package com.stackknowledge.mapper.response.mission

import com.stackknowledge.dto.response.mission.MissionResponse
import com.stackknowledge.mapper.user.toModel
import remote.response.mission.MissionResponseModel

fun MissionResponse.toModel(): MissionResponseModel =
    MissionResponseModel(
        id = this.id,
        title = this.title,
        point = this.point,
        missionStatus = this.missionStatus,
        user = this.user.toModel()
    )