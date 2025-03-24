package com.example.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.SearchTextField
import com.example.ui.elements.button.FilterButton
import com.example.ui.elements.card.CourseCard
import com.example.ui.elements.text.TextForButton
import com.example.ui.models.CourseUi
import com.example.ui.models.mockCourseUiList
import com.example.ui.theme.CoursesTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues
) {
    val courseList = mockCourseUiList
    MainScreenContent(
        modifier = modifier,
        innerPadding = innerPadding,
        displayText = "",
        courseList = courseList
    )
}

@Composable
private fun MainScreenContent(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    displayText: String,
    courseList: List<CourseUi>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = innerPadding.calculateTopPadding(),
                bottom = innerPadding.calculateBottomPadding(),
                start = 16.dp,
                end = 16.dp
            )
    ) {
        item {
            Row(modifier = Modifier) {
                SearchTextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp, bottom = 16.dp),
                    displayText = displayText,
                    hintText = stringResource(R.string.search_text_field_hint)
                ) { }
                FilterButton(modifier = Modifier)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                TextForButton(
                    modifier = Modifier.padding(end = 4.dp),
                    text = stringResource(R.string.for_data_publishing),
                    color = CoursesTheme.colors.green
                )
                Image(
                    painter = painterResource(R.drawable.arrow_down_up),
                    contentDescription = null
                )
            }
        }
        items(courseList) {
            CourseCard(modifier = Modifier.padding(bottom = 16.dp), course = it)
        }
    }
}

@Preview
@Composable
fun MainScreenContentPreview() {
    MainScreenContent(
        innerPadding = PaddingValues(top = 40.dp),
        displayText = "",
        courseList = mockCourseUiList
    )
}