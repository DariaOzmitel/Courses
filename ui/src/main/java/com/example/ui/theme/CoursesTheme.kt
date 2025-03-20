package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

object CoursesTheme {
    val colors: CoursesColors
        @Composable get() = LocalColors.current
    val typography: CoursesTypography
        @Composable get() = LocalTypography.current
}

@Composable
fun CoursesTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides AppColors,
        LocalTypography provides CoursesTypographyValue,
    ) {
        MaterialTheme(
            content = content
        )
    }
}