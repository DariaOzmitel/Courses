package com.example.domain.repository

interface AuthorizationRepository {
    suspend fun setFirstEntryFlag()
    suspend fun checkEntry(): Boolean
}