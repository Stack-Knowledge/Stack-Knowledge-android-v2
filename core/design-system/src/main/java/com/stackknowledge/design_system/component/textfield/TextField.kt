package com.stackknowledge.design_system.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stackknowledge.design_system.theme.StackKnowledgeAndroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StackKnowledgeTextField(
    modifier: Modifier = Modifier,
    label: String,
) {
    var text by remember { mutableStateOf("") }
    StackKnowledgeAndroidTheme { colors, typography ->
        TextField(
            value = text, onValueChange = { it },
            modifier = modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = colors.G5),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = colors.G5,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = colors.BLACK,
                unfocusedTextColor = colors.BLACK,
                focusedLabelColor = colors.G5,
                unfocusedLabelColor = colors.G5
            ),
            label = {
                Text(
                    text = label,
                    color = colors.G6,
                    style = typography.bodyMedium,
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTitleTextField(
    modifier: Modifier = Modifier,
) {
    var textCount by remember { mutableStateOf("0") }
    var text by remember { mutableStateOf("") }

    StackKnowledgeAndroidTheme { colors, typography ->
        TextField(
            value = text, onValueChange = { it },
            modifier = modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = colors.G5),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = colors.G5,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = colors.BLACK,
                unfocusedTextColor = colors.BLACK,
                focusedLabelColor = colors.G5,
                unfocusedLabelColor = colors.G5
            ),

            label = {
                Row {
                    Text(
                        text = "제목을 작성해 주시기 바랍니다.",
                        color = colors.G6,
                        style = typography.bodyMedium,
                    )

                    Spacer(modifier = modifier.weight(1f))

                    Text(
                        text = "$textCount/20",
                        color = colors.G6,
                        style = typography.bodyMedium,
                    )
                }
            }
        )
    }
}

@Preview
@Composable
fun StackKnowledgeTextFieldPre() {
    InputTitleTextField()
}