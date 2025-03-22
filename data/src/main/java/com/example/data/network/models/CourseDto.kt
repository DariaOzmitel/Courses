package com.example.data.network.models

internal data class CourseDto(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String
)

internal data class CoursesDto(
    val courses: List<CourseDto>
)

