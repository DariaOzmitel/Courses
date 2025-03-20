package com.example.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


@Immutable
data class CoursesColors(
    val dark: Color,
    val white: Color,
    val green: Color,
    val darkGrey: Color,
    val lightGrey: Color,
    val stroke: Color,
    val glass: Color,
    val caption: Color,
)

val AppColors = CoursesColors(
    dark = Color(0xFF151515),
    white = Color(0xFFF2F2F3),
    green = Color(0xFF12B956),
    darkGrey = Color(0xFF24252A),
    lightGrey = Color(0xFF32333A),
    stroke = Color(0xFF4D555E),
    glass = Color(0xFF32333A),
    caption = Color(0xFFF2F2F3)
)

internal val LocalColors = staticCompositionLocalOf { AppColors }