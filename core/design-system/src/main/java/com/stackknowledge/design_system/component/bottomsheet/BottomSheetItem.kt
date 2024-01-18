package com.stackknowledge.design_system.component.bottomsheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.R
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@Composable
fun BottomSheetItem(
    modifier: Modifier = Modifier
) {
    StackKnowledgeAndroidTheme { colors, typography ->  
        Row(
            modifier = modifier
                .background(
                    color = colors.P2,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(60.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
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
            }

            Row(
                modifier = modifier
                    .background(
                        color = colors.WHITE,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.plus_icon),
                    contentDescription = "Plus Icon"
                )
                Spacer(modifier = modifier.width(8.dp))

                Text(
                    text = "1",
                    style = typography.bodyMedium,
                    color = colors.BLACK
                )
                Spacer(modifier = modifier.width(8.dp))

                Image(
                    painter = painterResource(R.drawable.minus_icon),
                    contentDescription = "Minus Icon"
                )
            }
        }
    }
}

@Preview
@Composable
fun BottomSheetItemPre() {
    BottomSheetItem()
}