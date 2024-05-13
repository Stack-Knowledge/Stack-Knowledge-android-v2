package com.stackkowledge.mission.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.pretendard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateMissionTimer(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
) {
    var minute by remember { mutableStateOf("") }
    var second by remember { mutableStateOf("") }

    StackKnowledgeAndroidTheme { colors, typography ->
        Box(
            modifier = modifier
                .wrapContentSize()
                .background(
                    color = colors.WHITE,
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = modifier
                    .width(170.dp)
                    .height(170.dp),
                painter = painterResource(id = R.drawable.bg_limit_timer),
                contentDescription = "타이머 주황 원",
            )
            Row {
                Box {
                    if (minute.isNullOrEmpty()) {
                        Text(
                            modifier = modifier.align(Alignment.Center),
                            text = "00",
                            style = typography.headlineLarge,
                            color = colors.BLACK,
                        )
                    } else {
                        Text(
                            modifier = modifier.align(Alignment.Center),
                            text = "00",
                            style = typography.headlineLarge,
                            color = colors.WHITE
                        )
                    }

                    TextField(
                        value = minute,
                        onValueChange = {
                            if (minute.length <= 2) {
                                minute = it
                                onValueChange(it)
                            }
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done
                        ),
                        modifier = modifier
                            .width(80.dp)
                            .height(95.dp)
                            .background(color = Color.Transparent)
                            .align(Alignment.Center)
                        ,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedTextColor = colors.BLACK,
                            unfocusedTextColor = colors.BLACK
                        ),
                        textStyle = TextStyle(
                            fontFamily = pretendard,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.W700,
                            lineHeight = 48.sp,
                            textAlign = TextAlign.Center
                        ),
                        singleLine = true,
                    )
                }

                Text(
                    modifier = modifier.align(Alignment.CenterVertically),
                    text = ":",
                    style = typography.headlineLarge,
                    color = colors.BLACK
                )
                Box {
                    if (second.isNullOrEmpty()) {
                        Text(
                            modifier = modifier.align(Alignment.Center),
                            text = "00",
                            style = typography.headlineLarge,
                            color = colors.BLACK
                        )
                    } else {
                        Text(
                            modifier = modifier.align(Alignment.Center),
                            text = "00",
                            style = typography.headlineLarge,
                            color = colors.WHITE
                        )
                    }
                    TextField(
                        value = second,
                        onValueChange = {
                            if (second.length <= 2) {
                                second = it
                                onValueChange(it)
                            }
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done
                        ),
                        modifier = modifier
                            .width(80.dp)
                            .height(95.dp)
                            .background(color = Color.Transparent)
                            .align(Alignment.Center),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedTextColor = colors.BLACK,
                            unfocusedTextColor = colors.BLACK
                        ),
                        textStyle = TextStyle(
                            fontFamily = pretendard,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.W700,
                            lineHeight = 48.sp,
                            textAlign = TextAlign.Center
                        ),
                        singleLine = true,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CreateMissionTimerPre() {
    CreateMissionTimer(
        onValueChange = {}
    )
}