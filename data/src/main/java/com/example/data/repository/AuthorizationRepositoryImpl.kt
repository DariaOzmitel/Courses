package com.example.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.domain.repository.AuthorizationRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

internal class AuthorizationRepositoryImpl(
    private val context: Context
) : AuthorizationRepository {
    override suspend fun setFirstEntryFlag() {
        context.dataStore.edit { preferences ->
            preferences[ENTRY_KEY] = false
        }
    }

    override suspend fun checkEntry() =
        context.dataStore.data.map { preferences ->
            preferences.contains(ENTRY_KEY)
        }.first()

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "first_entry")
        private val ENTRY_KEY = booleanPreferencesKey("entry")
    }
}