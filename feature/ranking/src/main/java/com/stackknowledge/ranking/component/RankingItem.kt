package com.stackknowledge.ranking.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.design_system.R

@Composable
fun RankingItem(
    modifier: Modifier = Modifier,
    rankingNum: String,
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Row(
            modifier = modifier
                .height(54.dp)
                .fillMaxWidth()
                .background(
                    color = colors.G7,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = rankingNum,
                style = typography.headlineMedium,
                color = colors.BLACK
            )
            Spacer(modifier = modifier.width(8.dp))
            Image(
                painter = painterResource(R.drawable.img_profile),
                contentDescription = "Profile",
                modifier = modifier
                    .width(40.dp)
                    .height(40.dp)
            )
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = "이동욱",
                style = typography.bodyMedium,
                color = colors.BLACK
            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = "1000",
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
    }
}

@Preview
@Composable
fun RankingItemPre() {
    RankingItem(
        rankingNum = "1"
    )
}