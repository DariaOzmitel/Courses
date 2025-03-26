package com.example.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R

@Composable
internal fun AccountScreen(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = innerPadding.calculateTopPadding(),
                bottom = innerPadding.calculateBottomPadding(),
            ),
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.account_screen),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun OnboardingScreenPreview() {
    OnboardingScreen(innerPadding = PaddingValues(0.dp)) {}
}