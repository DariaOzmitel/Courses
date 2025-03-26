package com.example.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.button.GreenButton
import com.example.ui.elements.text.TextHeadline
import com.example.ui.ignoreHorizontalParentPadding
import com.example.ui.theme.CoursesTheme

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    onButtonClickListener: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = innerPadding.calculateTopPadding() + 100.dp,
                bottom = innerPadding.calculateBottomPadding(),
                start = 16.dp,
                end = 16.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextHeadline(
            modifier = Modifier.padding(bottom = 32.dp),
            text = stringResource(R.string.onboarding_title),
            color = CoursesTheme.colors.white
        )
        LazyRow(
            modifier = Modifier.ignoreHorizontalParentPadding(),
            state = rememberLazyListState(initialFirstVisibleItemScrollOffset = INITIAL_FIRST_VISIBLE_ITEM_SCROLL_OFFSET)
        ) {
            item {
                Image(
                    painter = painterResource(R.drawable.onboarding_image),
                    contentDescription = ""
                )
            }
        }
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
            GreenButton(
                modifier = Modifier.padding(bottom = 16.dp),
                text = stringResource(R.string.resume)
            ) {
                onButtonClickListener()
            }
        }
    }
}

@Preview
@Composable
private fun OnboardingScreenPreview() {
    OnboardingScreen(innerPadding = PaddingValues(top = 40.dp)) {}
}

private const val INITIAL_FIRST_VISIBLE_ITEM_SCROLL_OFFSET = 500