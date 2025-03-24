package com.example.ui.elements.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.theme.CoursesTheme


@Composable
internal fun FilterButton(
    modifier: Modifier = Modifier,
    onButtonClickListener: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(28.dp))
            .background(CoursesTheme.colors.darkGrey)
            .clickable { onButtonClickListener() }) {
        Image(
            modifier = Modifier.padding(16.dp),
            painter = painterResource(R.drawable.funnel),
            contentDescription = null
        )


    }
}

@Preview
@Composable
private fun FilterButtonPreview() {
    FilterButton()
}