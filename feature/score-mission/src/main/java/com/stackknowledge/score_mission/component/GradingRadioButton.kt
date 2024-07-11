package com.stackknowledge.score_mission.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.button.StackKnowledgeButton
import com.stackknowledge.design_system.component.button.enumclass.ButtonState

@Composable
fun GradingRadioButton(
    isSelected: Boolean,
    onClick: (() -> Unit)?,
    onAnswer: () -> Unit,
    onWrongAnswer: () -> Unit,
    openDialog: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { mutableStateOf(MutableInteractionSource()) }

    StackKnowledgeAndroidTheme { colors, typography ->
        Column(
            modifier = modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = colors.WHITE)
            ) {
                Spacer(modifier = modifier.weight(1f))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.correct),
                        style = typography.bodyMedium,
                        color = colors.BLACK,
                        modifier = modifier.padding(end = 6.dp)
                    )

                    Canvas(
                        modifier = modifier
                            .width(24.dp)
                            .height(24.dp)
                            .clickable(
                                interactionSource = interactionSource.value,
                                indication = rememberRipple(bounded = false)
                            ) {
                                onClick?.invoke()
                                onAnswer()
                            }
                            .padding(end = 12.dp),
                    ) {
                        drawCircle(
                            color = if (isSelected) colors.G8 else colors.P1,
                            style = if (isSelected) Stroke(width = 2.dp.toPx()) else Stroke(width = 3.dp.toPx())
                        )
                    }

                    Text(
                        text = stringResource(id = R.string.incorrect),
                        style = typography.bodyMedium,
                        color = colors.BLACK,
                        modifier = Modifier.padding(end = 6.dp)
                    )

                    Canvas(
                        modifier = modifier
                            .width(24.dp)
                            .height(24.dp)
                            .clickable(
                                interactionSource = interactionSource.value,
                                indication = rememberRipple(bounded = false)
                            ) {
                                onClick?.invoke()
                                onWrongAnswer()
                            }
                            .padding(end = 12.dp),
                    ) {
                        drawCircle(
                            color = if (isSelected) colors.P1 else colors.G8,
                            style = if (isSelected) Stroke(width = 3.dp.toPx()) else Stroke(width = 2.dp.toPx())
                        )
                    }
                }
            }

            Spacer(modifier = modifier.weight(1f))

            StackKnowledgeButton(
                text = stringResource(id = R.string.submit),
                enable = ButtonState.ACTIVATE,
                modifier = modifier
                    .height(60.dp),
                onClick = openDialog
            )

            Spacer(modifier = modifier.height(72.dp))

        }
    }
}