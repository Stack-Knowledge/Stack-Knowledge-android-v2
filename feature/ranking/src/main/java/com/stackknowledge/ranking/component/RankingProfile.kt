package com.stackknowledge.ranking.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
fun RankingProfile(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->  
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(color = colors.WHITE),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.img_profile),
                contentDescription = "Profile",
                modifier = modifier
                    .width(110.dp)
                    .height(110.dp)
            )
            Spacer(modifier = modifier.height(12.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "10위",
                    style = typography.bodyMedium,
                    color = colors.BLACK
                )
                Spacer(modifier = modifier.width(6.dp))
                Text(
                    text = "|",
                    style = typography.bodySmall,
                    color = colors.G1
                )
                Spacer(modifier = modifier.width(6.dp))
                Text(
                    text = "이동욱",
                    style = typography.bodyMedium,
                    color = colors.BLACK
                )
                Spacer(modifier = modifier.width(6.dp))
                Text(
                    text = "|",
                    style = typography.bodySmall,
                    color = colors.G1
                )
                Spacer(modifier = modifier.width(6.dp))
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
}

@Preview
@Composable
fun RankingProfilePre() {
    RankingProfile()
}