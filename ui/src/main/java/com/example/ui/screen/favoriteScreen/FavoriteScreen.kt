package com.example.ui.screen.favoriteScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.R
import com.example.ui.elements.ProgressIndicator
import com.example.ui.elements.card.CourseCard
import com.example.ui.elements.text.TextTitleLarge
import com.example.ui.models.CourseUi
import com.example.ui.models.mockCourseUiList
import com.example.ui.theme.CoursesTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun FavoriteScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues
) {
    val viewModel: FavoriteScreenViewModel = koinViewModel()
    val favoriteState by viewModel.getFavoriteState().collectAsStateWithLifecycle()

    when (val state = favoriteState) {
        is FavoriteState.Loading -> {
            ProgressIndicator()
        }

        is FavoriteState.CoursesList -> {
            FavoriteScreenContent(
                modifier = modifier,
                innerPadding = innerPadding,
                courseList = state.coursesList,
                onBookmarkButtonClickListener = { viewModel.changeFavoriteStatus(it) }
            )
        }
    }
}

@Composable
private fun FavoriteScreenContent(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    courseList: List<CourseUi>,
    onBookmarkButtonClickListener: (Int) -> Unit,
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
            TextTitleLarge(
                modifier = Modifier.padding(vertical = 16.dp),
                text = stringResource(R.string.favorite),
                color = CoursesTheme.colors.white
            )
        }
        items(courseList) {
            CourseCard(
                modifier = Modifier.padding(bottom = 16.dp),
                course = it,
                onBookmarkButtonClickListener = { onBookmarkButtonClickListener(it.id) }
            )
        }
    }
}

@Preview
@Composable
private fun MainScreenContentPreview() {
    FavoriteScreenContent(
        innerPadding = PaddingValues(top = 40.dp),
        courseList = mockCourseUiList,
        onBookmarkButtonClickListener = {}
    )
}