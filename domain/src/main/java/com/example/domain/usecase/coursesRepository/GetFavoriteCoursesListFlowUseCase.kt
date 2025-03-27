package com.example.domain.usecase.coursesRepository

import com.example.domain.models.Course
import com.example.domain.repository.CoursesRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteCoursesListFlowUseCase(
    private val repository: CoursesRepository
) {
    fun invoke(): Flow<List<Course>> {
        return repository.getFavoriteCoursesListFlow()
    }
}