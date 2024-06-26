package com.stackknowledge.mapper.request.mission

import com.stackknowledge.dto.request.mission.CreateMissionRequest
import remote.request.mission.CreateMissionRequestModel

fun CreateMissionRequestModel.toDto(): CreateMissionRequest =
    CreateMissionRequest(
        title = this.title,
        content = this.content,
        timeLimit = this.timeLimit,
    )