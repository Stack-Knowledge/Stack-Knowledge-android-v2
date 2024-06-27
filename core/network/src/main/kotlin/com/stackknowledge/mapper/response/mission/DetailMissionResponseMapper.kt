package com.stackknowledge.mapper.response.mission

import com.stackknowledge.dto.response.mission.DetailMissionResponse
import remote.response.mission.DetailMissionResponseModel

fun DetailMissionResponse.toModel(): DetailMissionResponseModel =
    DetailMissionResponseModel(
        title = this.title,
        content = this.content,
        timeLimit = this.timeLimit,
    )