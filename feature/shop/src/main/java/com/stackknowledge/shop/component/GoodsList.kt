package com.stackknowledge.shop.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.component.button.StackKnowledgeButton
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun GoodsList(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->  
        Column(
            modifier = modifier
                .background(color = colors.WHITE)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.goods),
                style = typography.bodyLarge,
                color = colors.BLACK,
                modifier = modifier
                    .padding(start = 16.dp)
            )

            Spacer(modifier = modifier.height(16.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = modifier.height(272.dp)
            ) {
                items(10) {
                    Box(
                        modifier = modifier
                            .padding(horizontal = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        GoodsItem()
                    }
                }
            }

            Spacer(modifier = modifier.height(32.dp))
            Box(
                modifier = modifier
                    .padding(horizontal = 16.dp)
            ) {
                StackKnowledgeButton(
                    text = stringResource(id = R.string.select),
                    modifier = modifier
                        .height(60.dp)
                )

                Spacer(modifier.height(28.dp))
            }
        }
    }
}

@Preview
@Composable
fun GoodsListPre() {
    GoodsList()
}