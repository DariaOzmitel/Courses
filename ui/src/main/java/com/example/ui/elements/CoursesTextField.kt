package com.example.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.elements.text.TextBodyMedium
import com.example.ui.theme.CoursesTheme

@Composable
internal fun CoursesTextField(
    modifier: Modifier = Modifier,
    hintText: String? = null,
    displayText: String,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = CoursesTheme.colors.lightGrey, shape = RoundedCornerShape(30.dp))
            .padding(16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = displayText,
            onValueChange = { onValueChange(it) },
            singleLine = true,
            textStyle = CoursesTheme.typography.bodyMedium.copy(color = CoursesTheme.colors.white),
            cursorBrush = SolidColor(CoursesTheme.colors.white)
        ) { innerTextField ->
            if (displayText.isBlank()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    hintText?.let {
                        TextBodyMedium(
                            modifier = Modifier.alpha(0.7f),
                            text = hintText,
                            color = CoursesTheme.colors.white
                        )
                    }
                }
            }
            innerTextField()
        }
    }
}

@Preview
@Composable
private fun CoursesTextFieldPreview() {
    CoursesTextField(displayText = "example@gmail.com") {
    }
}