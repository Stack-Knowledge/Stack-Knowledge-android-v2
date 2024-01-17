package com.stackknowledge.user.component

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun SolvedMissionItem(
    modifier: Modifier = Modifier,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Box(
            modifier = modifier
                .shadow(
                    color = colors.G1,
                    offsetX = (-4).dp,
                    offsetY = (-4).dp,
                    blurRadius = 20.dp,
                )
                .zIndex(-1f)
        ) {
            Box(
                modifier = modifier
                    .padding(bottom = 16.dp, end = 16.dp)
                    .clip(shape = RoundedCornerShape(20.dp))
                    .background(color = colors.WHITE)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .zIndex(1f),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = modifier.height(28.dp))

                    Text(
                        text = "박준호",
                        color = colors.BLACK,
                        style = typography.bodyLarge
                    )
                    Spacer(modifier = modifier.height(16.dp))

                    Text(
                        modifier = modifier.padding(horizontal = 16.dp),
                        text = "여기에 한줄설명 적을거임",
                        color = colors.G2,
                        style = typography.displayMedium
                    )

                    Spacer(modifier = modifier.height(46.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "1,000",
                            style = typography.bodyMedium,
                            color = colors.BLACK
                        )
                        Spacer(modifier = modifier.width(2.dp))
                        Text(
                            text = stringResource(R.string.mileage),
                            style = typography.bodySmall,
                            color = colors.BLACK
                        )
                    }
                    Spacer(modifier = modifier.height(16.dp))

                }
            }
        }
    }
}

fun Modifier.shadow(
    color: Color = Color.Black,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
) = then(
    drawBehind {
        drawIntoCanvas { canvas ->
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter =
                    (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
            }
            frameworkPaint.color = color.toArgb()

            val leftPixel = offsetX.toPx()
            val topPixel = offsetY.toPx()
            val rightPixel = size.width + topPixel
            val bottomPixel = size.height + leftPixel

            canvas.drawRect(
                left = 0f,
                top = 0f,
                right = rightPixel,
                bottom = bottomPixel,
                paint = paint,
            )
        }
    }
)

@Preview
@Composable
fun SolvedMissionItemPre(
    modifier: Modifier = Modifier,
) {
    SolvedMissionItem()
}