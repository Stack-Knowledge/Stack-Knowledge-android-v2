package com.stackknowledge.shop.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun GoodsItem(
    modifier: Modifier = Modifier,
) {
    var checked by remember { mutableStateOf(true) }
    
    val imageResource = if(checked) {
        painterResource(R.drawable.uncheck_image)
    } else {
        painterResource(R.drawable.check_image)
    }

    StackKnowledgeAndroidTheme { colors, typography ->
        Column(
            modifier = modifier
                .background(color = colors.WHITE)
        ) {
            Box() {
                Image(
                    painter = painterResource(R.drawable.goods_image),
                    contentDescription = "Goods Image"
                )
                Box(
                    modifier = modifier
                        .padding(start = 8.dp, top = 8.dp)
                ) {
                    Image(
                        painter = imageResource,
                        contentDescription = null,
                        modifier = modifier
                            .width(16.dp)
                            .height(16.dp)
                            .clickable {
                                checked = !checked
                            }
                        ,
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Spacer(modifier = modifier.height(4.dp))
            Text(
                text = "외출권",
                style = typography.bodyMedium,
                color = colors.BLACK
            )

            Spacer(modifier = modifier.height(4.dp))
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

@Preview
@Composable
fun GoodsItemPre() {
    GoodsItem()
}