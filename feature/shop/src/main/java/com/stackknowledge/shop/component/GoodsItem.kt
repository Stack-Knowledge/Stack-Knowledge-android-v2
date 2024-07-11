package com.stackknowledge.shop.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import remote.response.item.GetItemResponseModel

@Composable
fun GoodsItem(
    modifier: Modifier = Modifier,
    itemData: GetItemResponseModel,
    onItemCheckButtonClick: (GetItemResponseModel) -> Unit,
    onItemUnCheckButtonClick: (GetItemResponseModel) -> Unit,
) {
    val checked = remember { mutableStateOf(true) }

    val imageResource = if (checked.value) {
        painterResource(R.drawable.uncheck_image)
    } else {
        painterResource(R.drawable.check_image)
    }

    StackKnowledgeAndroidTheme { colors, typography ->
        Column(
            modifier = modifier
                .background(color = colors.WHITE)
        ) {
            Box(
                modifier = modifier
                    .clip(shape = RoundedCornerShape(10.dp))
                    .clickable {
                        if (checked.value) {
                            onItemCheckButtonClick(itemData)
                        } else {
                            onItemUnCheckButtonClick(itemData)
                        }
                        checked.value = !checked.value
                    }
            ) {
                val imagePainter = if (itemData.image.isEmpty()) {
                    painterResource(id = R.drawable.goods_image)
                } else {
                    rememberAsyncImagePainter(model = itemData.image)
                }

                Image(
                    painter = imagePainter,
                    contentDescription = "Goods Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                )

                Box(
                    modifier = Modifier
                        .padding(start = 8.dp, top = 8.dp)
                ) {
                    Image(
                        painter = imageResource,
                        contentDescription = null,
                        modifier = Modifier
                            .width(16.dp)
                            .height(16.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = itemData.name,
                style = typography.bodyMedium,
                color = colors.BLACK
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${itemData.price}",
                    style = typography.bodyMedium,
                    color = colors.BLACK
                )

                Spacer(modifier = Modifier.width(2.dp))

                Text(
                    text = stringResource(R.string.mileage),
                    style = typography.bodySmall,
                    color = colors.BLACK
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun GoodsItemPre() {
    GoodsItem(
        onItemCheckButtonClick = {},
        itemData = GetItemResponseModel(
            id = "",
            price = 1000,
            name = "정영운 글러브",
            image = ""
        ),
        onItemUnCheckButtonClick = {}
    )
}
