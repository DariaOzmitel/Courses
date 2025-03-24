package com.example.ui.elements

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.text.TextBodyMedium
import com.example.ui.theme.CoursesTheme

@Composable
internal fun SearchTextField(
    modifier: Modifier = Modifier,
    hintText: String? = null,
    displayText: String,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = CoursesTheme.colors.darkGrey, shape = RoundedCornerShape(28.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = displayText,
            onValueChange = { onValueChange(it) },
            singleLine = true,
            textStyle = CoursesTheme.typography.bodyMedium.copy(color = CoursesTheme.colors.white),
            cursorBrush = SolidColor(CoursesTheme.colors.white),
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.padding(end = 8.dp),
                        painter = painterResource(R.drawable.icon_search),
                        contentDescription = null
                    )
                    Box(modifier = Modifier.weight(1f)) {
                        if (displayText.isEmpty() && hintText != null) {
                            TextBodyMedium(
                                modifier = Modifier.alpha(0.7f),
                                text = hintText,
                                color = CoursesTheme.colors.white
                            )
                        }
                        innerTextField()
                    }
                }
            }
        )
    }
}

@Preview
@Composable
private fun SearchTextFieldPreview() {
    SearchTextField(displayText = "", hintText = stringResource(R.string.search_text_field_hint)) {
    }
}