package com.example.data.database.favoriteCourses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class FavoriteCoursesDbModel(
    @PrimaryKey
    val courseId: Int
)