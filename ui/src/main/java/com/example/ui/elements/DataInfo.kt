package com.example.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.elements.text.TextCaption
import com.example.ui.models.mockCourseUi
import com.example.ui.theme.CoursesTheme

@Composable
internal fun DataInfo(modifier: Modifier = Modifier, data: String) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(CoursesTheme.colors.glass)
    ) {
        TextCaption(
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
            text = data,
            color = CoursesTheme.colors.white
        )
    }
}

@Preview
@Composable
private fun DataInfoPreview() {
    DataInfo(data = mockCourseUi.publishDate)
}