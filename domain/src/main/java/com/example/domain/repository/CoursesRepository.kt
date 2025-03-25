package com.example.domain.repository

import com.example.domain.models.Course
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {
    fun getCoursesListFlow(): Flow<List<Course>>
    fun getFavoriteCoursesListFlow(): Flow<List<Course>>
    fun sortListByPublishingDate()
    suspend fun changeFavoriteStatus(courseId: Int)
}