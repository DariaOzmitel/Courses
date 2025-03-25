package com.example.domain.usecase

import com.example.domain.repository.CoursesRepository

class ChangeFavoriteStatusUseCase(
    private val repository: CoursesRepository
) {
    suspend fun invoke(courseId: Int) {
        return repository.changeFavoriteStatus(courseId)
    }
}