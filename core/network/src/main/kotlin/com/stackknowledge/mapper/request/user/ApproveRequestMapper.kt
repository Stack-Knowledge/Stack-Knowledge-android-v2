package com.stackknowledge.mapper.request.user

import com.stackknowledge.dto.request.user.ApproveRequest
import remote.request.user.ApproveRequestModel

fun ApproveRequest.toModel(): ApproveRequestModel =
    ApproveRequestModel(
        approveStatus = this.approveStatus
    )