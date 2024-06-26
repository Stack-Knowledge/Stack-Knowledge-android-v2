package com.stackknowledge.mapper.response.mission

import com.stackknowledge.dto.response.mission.Missions
import remote.response.mission.MissionsModel

fun Missions.toModel(): MissionsModel =
    MissionsModel(
        id = this.id,
        title = this.title,
        point = this.point,
        missionStatus = this.missionStatus,
        user = this.user,
    )