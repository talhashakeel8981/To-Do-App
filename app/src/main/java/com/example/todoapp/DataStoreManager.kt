package com.example.todoapp

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Extension property on Context
val Context.dataStore by preferencesDataStore(name = "settings")

object ThemeDataStore {
    private val DARK_MODE_KEY = booleanPreferencesKey("dark_mode")

    fun getDarkMode(context: Context): Flow<Boolean> {
        return context.dataStore.data
            .map { preferences ->
                preferences[DARK_MODE_KEY] ?: false
            }
    }

    suspend fun saveDarkMode(context: Context, isDark: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[DARK_MODE_KEY] = isDark
        }
    }
}
