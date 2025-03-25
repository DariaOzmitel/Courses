package com.example.domain.usecase

import com.example.domain.repository.CoursesRepository

class SortListByPublishingDateUseCase(
    private val repository: CoursesRepository
) {
    fun invoke() {
        return repository.sortListByPublishingDate()
    }
}