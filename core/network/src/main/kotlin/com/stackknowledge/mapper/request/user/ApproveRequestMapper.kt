package com.stackknowledge.mapper.request.user

import com.stackknowledge.dto.request.user.ApproveRequest
import remote.request.user.ApproveRequestModel

fun ApproveRequestModel.toDto(): ApproveRequest =
    ApproveRequest(
        approveStatus = this.approveStatus,
    )