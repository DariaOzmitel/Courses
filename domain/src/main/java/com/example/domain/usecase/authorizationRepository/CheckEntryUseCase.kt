package com.example.domain.usecase.authorizationRepository

import com.example.domain.repository.AuthorizationRepository

class CheckEntryUseCase(
    private val repository: AuthorizationRepository
) {
    suspend operator fun invoke(): Boolean {
        return repository.checkEntry()
    }
}