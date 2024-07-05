package com.stackknowledge.ranking.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.util.Event
import com.stackknowledge.usecase.student.GetMyInformationUseCase
import com.stackknowledge.usecase.student.GetStudentPointRankingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import remote.response.student.GetMyInformationResponse
import remote.response.student.GetStudentPointRankingResponse
import remote.user.UserModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val getStudentPointRankingUseCase: GetStudentPointRankingUseCase,
    private val getMyInformationUseCase: GetMyInformationUseCase,
) : ViewModel() {
    private val _getStudentPointRankingResponse =
        MutableStateFlow<Event<GetStudentPointRankingResponse>>(Event.Loading)
    val getStudentPointRankingResponse = _getStudentPointRankingResponse.asStateFlow()

    private val _getMyInformationResponse =
        MutableStateFlow<Event<GetMyInformationResponse>>(Event.Loading)
    val getMyInformationResponse = _getMyInformationResponse.asStateFlow()

    var studentPointRankingList = mutableStateOf(
        GetStudentPointRankingResponse(
            cumulatePoint = 1,
            id = UUID.randomUUID(),
            user = UserModel(
                id = UUID.randomUUID(),
                name = "",
                profileImage = ""
            )
        )
    )
        private set

    var myInformation = mutableStateOf(
        GetMyInformationResponse(
            cumulatePoint = 1,
            currentPoint = 1,
            id = UUID.randomUUID(),
            user = UserModel(
                id = UUID.randomUUID(),
                name = "",
                profileImage = ""
            )
        )
    )
}