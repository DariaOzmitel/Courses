package com.example.domain.usecase.coursesRepository

import com.example.domain.repository.CoursesRepository

class ChangeFavoriteStatusUseCase(
    private val repository: CoursesRepository
) {
    suspend fun invoke(courseId: Int) {
        return repository.changeFavoriteStatus(courseId)
    }
}