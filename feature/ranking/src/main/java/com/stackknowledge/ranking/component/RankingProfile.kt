package com.stackknowledge.ranking.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.design_system.R
import com.stackknowledge.ranking.viewModel.uistate.GetMyInformationUiState

@Composable
fun RankingProfile(
    modifier: Modifier = Modifier,
    getMyInformationUiState: GetMyInformationUiState
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        when (getMyInformationUiState) {
            is GetMyInformationUiState.Loading -> {}
            is GetMyInformationUiState.Success -> {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(color = colors.WHITE),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (getMyInformationUiState.getMyInformationResponseModel.user.profileImage.isNullOrEmpty()) {
                        Image(
                            painter = painterResource(R.drawable.img_profile),
                            contentDescription = "Profile",
                            modifier = modifier
                                .width(40.dp)
                                .height(40.dp)
                        )
                    } else {
                        AsyncImage(
                            model = getMyInformationUiState.getMyInformationResponseModel.user.profileImage,
                            contentDescription = "Profile",
                            modifier = modifier
                                .width(40.dp)
                                .height(40.dp)
                        )
                    }
                    Spacer(modifier = modifier.height(12.dp))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ProfileText(text = "1등", style = typography.bodyMedium, color = colors.BLACK)
                        DividerText()
                        ProfileText(text = getMyInformationUiState.getMyInformationResponseModel.user.name, style = typography.bodyMedium, color = colors.BLACK)
                        DividerText()
                        ProfileText(text = getMyInformationUiState.getMyInformationResponseModel.currentPoint.toString(), style = typography.bodyMedium, color = colors.BLACK)
                        Spacer(modifier = modifier.width(2.dp))
                        ProfileText(text = stringResource(R.string.mileage), style = typography.bodySmall, color = colors.BLACK)
                    }
                }
            }
            is GetMyInformationUiState.Error -> {}
        }
    }
}

@Composable
fun ProfileText(text: String, style: TextStyle, color: Color) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Text(
            text = text,
            style = style,
            color = color
        )
        Spacer(modifier = Modifier.width(6.dp))
    }
}

@Composable
fun DividerText() {
    StackKnowledgeAndroidTheme { colors, typography ->
        Text(
            text = "|",
            style = typography.bodySmall,
            color = colors.G1
        )
        Spacer(modifier = Modifier.width(6.dp))
    }
}