package com.example.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.text.TextCaption
import com.example.ui.models.mockCourseUi
import com.example.ui.theme.CoursesTheme

@Composable
internal fun RateInfo(modifier: Modifier = Modifier, rate: String) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(CoursesTheme.colors.glass),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(modifier = Modifier.padding(start = 6.dp, end = 4.dp), painter = painterResource(R.drawable.star_fill), contentDescription = "")
        TextCaption(
            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, end = 6.dp),
            text = rate,
            color = CoursesTheme.colors.white
        )
    }
}

@Preview
@Composable
private fun RateInfoPreview() {
    RateInfo(rate = mockCourseUi.rate)
}