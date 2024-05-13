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
    onValueChange: (String) -> Unit,
    placeholder: String,
) {
    var text by remember { mutableStateOf("") }
    StackKnowledgeAndroidTheme { colors, typography ->
        TextField(
            value = text,
            onValueChange = { text = it; onValueChange(it) },
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
            placeholder = {
                Text(
                    text = placeholder,
                    color = colors.G6,
                    style = typography.bodyMedium,
                )
            },
            textStyle = typography.bodyMedium
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTitleTextField(
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var textCount by remember { mutableStateOf("0") }
    var text by remember { mutableStateOf("") }

    StackKnowledgeAndroidTheme { colors, typography ->
        TextField(
            value = text,
            onValueChange = {
                if (text.length <= 20) {
                    text = it
                    onValueChange(it)
                }
            },
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
            textStyle = typography.bodyMedium,

            placeholder = {
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
            },
            singleLine = true

        )
    }
}

@Preview
@Composable
fun StackKnowledgeTextFieldPre() {
    //  InputTitleTextField()
}