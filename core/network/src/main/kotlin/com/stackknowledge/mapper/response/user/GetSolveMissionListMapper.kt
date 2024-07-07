package com.stackknowledge.mapper.response.user

import com.stackknowledge.dto.response.user.GetSolveMissionList
import com.stackknowledge.mapper.user.toModel
import remote.response.user.GetSolveMissionListModel

fun GetSolveMissionList.toModel(): GetSolveMissionListModel =
    GetSolveMissionListModel(
        solveId = this.solveId,
        solveStatus = this.solveStatus,
        title = this.title,
        point = this.point,
        user = this.user.toModel(),
    )