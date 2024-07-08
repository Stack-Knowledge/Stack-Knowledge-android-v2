package com.stackknowledge.ranking.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
<<<<<<< Updated upstream
import androidx.lifecycle.viewModelScope
import com.example.common.result.Result
import com.example.common.result.asResult
import com.stackknowledge.ranking.viewModel.uistate.GetMyInformationUiState
import com.stackknowledge.ranking.viewModel.uistate.GetRankingUiState
import com.stackknowledge.usecase.mission.GetMissionUseCase
=======
import com.example.common.util.Event
>>>>>>> Stashed changes
import com.stackknowledge.usecase.student.GetMyInformationUseCase
import com.stackknowledge.usecase.student.GetStudentPointRankingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
<<<<<<< Updated upstream
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
=======
import remote.response.student.GetMyInformationResponseModel
import remote.response.student.GetStudentPointRankingResponseModel
import remote.user.UserModel
import java.util.UUID
>>>>>>> Stashed changes
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val getStudentPointRankingUseCase: GetStudentPointRankingUseCase,
    private val getMyInformationUseCase: GetMyInformationUseCase,
<<<<<<< Updated upstream
): ViewModel() {
    private val _getRankingUiState = MutableStateFlow<GetRankingUiState>(GetRankingUiState.Loading)
    internal val getRankingUiState = _getRankingUiState.asStateFlow()

    private val _getMyInformationUiState = MutableStateFlow<GetMyInformationUiState>(GetMyInformationUiState.Loading)
    internal val getMyInformationUiState = _getMyInformationUiState.asStateFlow()
    internal fun getRanking() = viewModelScope.launch {
        getStudentPointRankingUseCase()
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> _getRankingUiState.value = GetRankingUiState.Loading
                    is Result.Success -> _getRankingUiState.value = GetRankingUiState.Success(result.data)
                    is Result.Error -> _getRankingUiState.value = GetRankingUiState.Error(result.exception)
                }
            }
    }

    internal fun getMyProfile() = viewModelScope.launch {
        getMyInformationUseCase()
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> _getMyInformationUiState.value = GetMyInformationUiState.Loading
                    is Result.Success -> _getMyInformationUiState.value = GetMyInformationUiState.Success(result.data)
                    is Result.Error -> _getMyInformationUiState.value = GetMyInformationUiState.Error(result.exception)
                }
            }
    }
=======
) : ViewModel() {
    private val _getStudentPointRankingResponse =
        MutableStateFlow<Event<GetStudentPointRankingResponseModel>>(Event.Loading)
    val getStudentPointRankingResponse = _getStudentPointRankingResponse.asStateFlow()

    private val _getMyInformationResponse =
        MutableStateFlow<Event<GetMyInformationResponseModel>>(Event.Loading)
    val getMyInformationResponse = _getMyInformationResponse.asStateFlow()

    var studentPointRankingList = mutableStateOf(
        GetStudentPointRankingResponseModel(
            cumulatePoint = 1,
            id = "",
            user = UserModel(
                id = "",
                name = "",
                profileImage = ""
            )
        )
    )
        private set

    var myInformation = mutableStateOf(
        GetMyInformationResponseModel(
            cumulatePoint = 1,
            currentPoint = 1,
            id = "",
            user = UserModel(
                id = "",
                name = "",
                profileImage = ""
            )
        )
    )
>>>>>>> Stashed changes
}