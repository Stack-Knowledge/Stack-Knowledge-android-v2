package com.stackknowledge.shop.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.rememberAsyncImagePainter
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.design_system.utils.shadow
import remote.item.ItemModel
import remote.response.order.ViewAllOrderResponseModel
import remote.user.UserModel

@Composable
fun OrderedGoodsItem(
    modifier: Modifier = Modifier,
    orderedItemData: ViewAllOrderResponseModel,
    onItemClick: (String) -> Unit,
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
                .clickable {
                    onItemClick(orderedItemData.id)
                }
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
                Box {
                    val imagePainter = if (orderedItemData.item.image.isEmpty()) {
                        painterResource(id = R.drawable.goods_image)
                    } else {
                        rememberAsyncImagePainter(model = orderedItemData.item.image)
                    }

                    Image(
                        painter = imagePainter,
                        contentDescription = "Goods Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(
                                start = 8.dp,
                                end = 8.dp,
                                top = 8.dp,
                                bottom = 60.dp
                            )
                            .size(140.dp, 113.dp)
                    )

                    Row(
                        modifier = modifier.padding(
                            end = 8.dp,
                            top = 129.dp,
                        ),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            modifier = modifier.padding(
                                start = 8.dp
                            ),
                            text = orderedItemData.user.name,
                            color = colors.BLACK,
                            style = typography.bodyMedium
                        )

                        Spacer(modifier = Modifier.weight(1f))


                        Text(
                            text = "${orderedItemData.count}개",
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
                            modifier = modifier.padding(start = 8.dp),
                            text = orderedItemData.item.name,
                            color = colors.BLACK,
                            style = typography.displayMedium,
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                modifier = modifier.padding(end = 2.dp),
                                text = "${orderedItemData.item.price}",
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
}

@Preview
@Composable
fun OrderedGoodsItemPre() {
    OrderedGoodsItem(
        onItemClick = {},
        orderedItemData = ViewAllOrderResponseModel(
            id = "",
            item = ItemModel(
                itemId = "",
                name = "상품 이름",
                price = 1000,
                image = "https://image.com"
            ),
            count = 1,
            price = 1000,
            user = UserModel(
                id = "",
                name = "유저 이름",
                profileImage = "https://image.com"
            )

        )
    )
}