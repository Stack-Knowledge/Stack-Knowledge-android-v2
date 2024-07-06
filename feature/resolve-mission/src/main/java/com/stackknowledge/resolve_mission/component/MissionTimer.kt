package com.stackknowledge.resolve_mission.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun MissionTimer(
    modifier: Modifier = Modifier,
    minute: String,
    second: String,
    time: @Composable () -> Unit,
) {
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
            Text(
                text = "$minute : $second",
                style = typography.headlineLarge,
                color = colors.BLACK
            )
        }
    }
    if (minute == "0" && second == "0") {
        time()
    }
}

//@Preview
//@Composable
//fun MissionTimerPre() {
//    MissionTimer(
//        minute = "13",
//        second = "00"
//    )
//}