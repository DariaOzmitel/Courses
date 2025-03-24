package com.example.ui.elements.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.theme.CoursesTheme


@Composable
internal fun BookmarkButton(
    modifier: Modifier = Modifier,
    inBookmark: Boolean = false,
    onButtonClickListener: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(CoursesTheme.colors.glass)
            .clickable { onButtonClickListener() }) {
        when (inBookmark) {
            true -> {
                Image(
                    modifier = Modifier.padding(6.dp),
                    painter = painterResource(R.drawable.bookmark_fill),
                    contentDescription = null
                )
            }
            false -> {
                Image(
                    modifier = Modifier.padding(6.dp),
                    painter = painterResource(R.drawable.bookmark),
                    contentDescription = null
                )
            }
        }

    }
}

@Preview
@Composable
private fun BookmarkButtonPreview() {
    BookmarkButton {}
}