package com.stackknowledge.mapper.request.mission

import com.stackknowledge.dto.request.mission.DetailMissionRequest
import remote.request.mission.DetailMissionRequestModel

fun DetailMissionRequestModel.toDto(): DetailMissionRequest =
    DetailMissionRequest(
        missionId = this.missionId
    )