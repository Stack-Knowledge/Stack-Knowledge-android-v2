package com.stackknowledge.shop.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.design_system.utils.shadow

@Composable
fun OrderedGoodsItem(
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
            ) {
                Box(
                    modifier = modifier
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 60.dp)
                        .size(140.dp, 113.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(color = colors.G1)
                ) {
                    // 여기 주문된 상품 Image를 Box에서 Image Composable로 바꿔서 넣으면 될듯합니다.
                }

                Row(
                    modifier = modifier.padding(
                        end = 8.dp,
                        top = 129.dp,
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        modifier = modifier.padding(
                            start = 8.dp, end = 83.dp
                        ),
                        text = "정찬교",
                        color = colors.BLACK,
                        style = typography.bodyMedium
                    )

                    Text(
                        text = "3개",
                        color = colors.BLACK,
                        style = typography.bodyMedium
                    )

                }

                Row(
                    modifier = modifier.padding(
                        end = 8.dp,
                        top = 158.dp,
                        bottom = 8.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Text(
                        modifier = modifier.padding(start = 8.dp, end = 56.dp),
                        text = "외출권",
                        color = colors.BLACK,
                        style = typography.displayMedium,
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Text(
                            modifier = modifier.padding(end = 2.dp),
                            text = "1,000",
                            style = typography.bodyMedium,
                            color = colors.BLACK
                        )

                        Text(
                            text = "원",
                            style = typography.bodySmall,
                            color = colors.BLACK
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun OrderedGoodsItemPre() {
    OrderedGoodsItem()
}