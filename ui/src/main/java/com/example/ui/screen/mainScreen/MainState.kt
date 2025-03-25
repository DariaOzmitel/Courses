package com.example.ui.screen.mainScreen

import com.example.ui.models.CourseUi

internal sealed class MainState {
    data class CoursesList(
        val coursesList: List<CourseUi>,
    ) : MainState()

    object Loading : MainState()
}