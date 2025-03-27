package com.example.domain.usecase.authorizationRepository

import com.example.domain.repository.AuthorizationRepository

class SetFirstEntryFlagUseCase(
    private val repository: AuthorizationRepository
) {
    suspend operator fun invoke() {
        return repository.setFirstEntryFlag()
    }
}