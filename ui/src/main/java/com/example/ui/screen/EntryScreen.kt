package com.example.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.elements.CoursesTextField
import com.example.ui.elements.button.ButtonClassmates
import com.example.ui.elements.button.ButtonVk
import com.example.ui.elements.button.GreenButton
import com.example.ui.elements.text.TextButtonSmall
import com.example.ui.elements.text.TextHeadline
import com.example.ui.elements.text.TextTitleMedium
import com.example.ui.theme.CoursesTheme

@Composable
fun EntryScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues
) {
    EntryScreenContent(modifier = modifier, innerPadding = innerPadding, displayText = "")
}

@Composable
fun EntryScreenContent(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    displayText: String,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = innerPadding.calculateTopPadding() + 100.dp,
                bottom = innerPadding.calculateBottomPadding(),
                start = 16.dp,
                end = 16.dp
            )
    ) {
        TextHeadline(
            modifier = Modifier.padding(bottom = 28.dp),
            text = stringResource(R.string.entry),
            color = CoursesTheme.colors.white
        )
        TextTitleMedium(
            modifier = Modifier.padding(bottom = 8.dp),
            text = stringResource(R.string.email),
            color = CoursesTheme.colors.white
        )
        CoursesTextField(
            modifier = Modifier.padding(bottom = 16.dp),
            hintText = stringResource(R.string.email_example),
            displayText = displayText
        ) {}
        TextTitleMedium(
            modifier = Modifier.padding(bottom = 8.dp),
            text = stringResource(R.string.password),
            color = CoursesTheme.colors.white
        )
        CoursesTextField(
            modifier = Modifier.padding(bottom = 24.dp),
            hintText = stringResource(R.string.password_hint),
            displayText = displayText
        ) {}
        GreenButton(
            modifier = Modifier.padding(bottom = 16.dp),
            text = stringResource(R.string.entry)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            TextButtonSmall(
                modifier = Modifier.padding(end = 4.dp),
                text = stringResource(R.string.no_account),
                color = CoursesTheme.colors.white
            )
            TextButtonSmall(
                text = stringResource(R.string.log_in),
                color = CoursesTheme.colors.green
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            TextButtonSmall(
                text = stringResource(R.string.forgot_password),
                color = CoursesTheme.colors.green
            )
        }
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),
            color = CoursesTheme.colors.stroke,
            thickness = 1.dp
        )
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)){
            ButtonVk(modifier = Modifier.weight(1f))
            ButtonClassmates(modifier = Modifier.weight(1f))
        }
    }
}

@Preview
@Composable
private fun EntryScreenPreview() {
    EntryScreen(innerPadding = PaddingValues(top = 40.dp))
}