package com.example.ui.elements.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.DataInfo
import com.example.ui.elements.RateInfo
import com.example.ui.elements.button.BookmarkButton
import com.example.ui.elements.text.TextBodySmall
import com.example.ui.elements.text.TextButtonSmall
import com.example.ui.elements.text.TextTitleMedium
import com.example.ui.models.CourseUi
import com.example.ui.models.mockCourseUi
import com.example.ui.theme.CoursesTheme

@Composable
internal fun CourseCard(
    modifier: Modifier = Modifier,
    course: CourseUi,
    onBookmarkButtonClickListener: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(CoursesTheme.colors.darkGrey)
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 16.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(114.dp)
                    .clip(RoundedCornerShape(12.dp)),
                painter = painterResource(R.drawable.courses_image),
                contentScale = ContentScale.Crop,
                alignment = BiasAlignment(0f, -0.8f),
                contentDescription = "",
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .height(114.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) { BookmarkButton(inBookmark = course.hasLike) { onBookmarkButtonClickListener() } }
                Row(modifier = Modifier.padding(bottom = 8.dp)) {
                    RateInfo(modifier = Modifier.padding(end = 4.dp), rate = course.rate)
                    DataInfo(data = course.publishDate)
                }
            }
        }
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            TextTitleMedium(
                modifier = Modifier
                    .padding(bottom = 12.dp),
                text = course.title,
                color = CoursesTheme.colors.white,
            )
            TextBodySmall(
                modifier = Modifier
                    .alpha(0.7f)
                    .padding(bottom = 10.dp),
                text = course.text,
                color = CoursesTheme.colors.white,
                maxLines = TEXT_MAX_LINES,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextTitleMedium(
                    modifier = Modifier,
                    text = String.format(
                        stringResource(id = R.string.price),
                        course.price
                    ),
                    color = CoursesTheme.colors.white,
                )
                Row {
                    TextButtonSmall(
                        modifier = Modifier
                            .padding(bottom = 12.dp),
                        text = stringResource(R.string.more),
                        color = CoursesTheme.colors.green,
                    )
                    Image(
                        painter = painterResource(R.drawable.arrow_right_short_fill),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CourseCardPreview() {
    CourseCard(course = mockCourseUi, onBookmarkButtonClickListener = {})
}

private const val TEXT_MAX_LINES = 2