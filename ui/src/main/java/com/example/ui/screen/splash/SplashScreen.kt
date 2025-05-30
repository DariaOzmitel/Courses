package com.example.ui.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.ui.R
import com.example.ui.theme.CoursesTheme
import org.koin.androidx.compose.koinViewModel

private const val ANIMATION_SPEED = 2.0f

@Composable
internal fun SplashScreen(modifier: Modifier = Modifier, animationEndListener: (Boolean) -> Unit) {
    val viewModel: SplashScreenViewModel = koinViewModel()
    val isEntryFirst by viewModel.getEntryStatus().collectAsStateWithLifecycle()
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(CoursesTheme.colors.dark),
        contentAlignment = Alignment.Center
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.green_loading))
        val logoAnimationState =
            animateLottieCompositionAsState(
                composition = composition,
                speed = ANIMATION_SPEED,
            )
        LottieAnimation(
            composition = composition,
            progress = { logoAnimationState.progress }
        )
        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
            animationEndListener(isEntryFirst)
        }
    }
}