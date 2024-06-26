package com.stackknowledge.dto.request.mission

data class CreateMissionRequest(
    val title: String,
    val content: String,
    val timeLimit: Int,
)
