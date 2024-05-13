package com.stackknowledge.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme
import com.stackknowledge.design_system.R

@Composable
fun RankingNumFirst(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Box(
            modifier = modifier
                .width(25.dp)
                .height(25.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ranking_first),
                contentDescription = "First Ranking",
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(R.string.ranking_first),
                style = typography.bodyMedium,
                color = colors.BLACK
            )
        }
    }
}

@Composable
fun RankingNumSecond(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Box(
            modifier = modifier
                .width(25.dp)
                .height(25.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ranking_second),
                contentDescription = "Second Ranking",
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(R.string.ranking_second),
                style = typography.bodyMedium,
                color = colors.BLACK
            )
        }
    }

}

@Composable
fun RankingNumThird(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->
        Box(
            modifier = modifier
                .width(25.dp)
                .height(25.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ranking_third),
                contentDescription = "Third Ranking",
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(R.string.ranking_third),
                style = typography.bodyMedium,
                color = colors.BLACK
            )
        }
    }
}

@Preview
@Composable
fun RankingNumPre() {
    RankingNumFirst()
    RankingNumSecond()
    RankingNumThird()
}