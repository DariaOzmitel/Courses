package com.example.domain.repository

import com.example.domain.models.Course
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {
    fun getCoursesListFlow(): Flow<List<Course>>
    fun sortListByPublishingDate()
}