package com.example.ui.screen.favoriteScreen

import com.example.ui.models.CourseUi

internal sealed class FavoriteState {
    data class CoursesList(
        val coursesList: List<CourseUi>,
    ) : FavoriteState()

    object Loading : FavoriteState()
}