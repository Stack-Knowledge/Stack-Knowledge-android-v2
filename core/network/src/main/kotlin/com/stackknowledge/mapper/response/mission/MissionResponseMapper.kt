package com.stackknowledge.mapper.response.mission

import com.stackknowledge.dto.response.mission.MissionResponse
import remote.response.mission.MissionResponseModel

fun MissionResponse.toModel(): MissionResponseModel =
    MissionResponseModel(
        missions = this.missions.toModel()
    )