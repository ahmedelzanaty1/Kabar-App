package com.example.kabarapp.Data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.kabarapp.Domain.manager.LocalUserManager
import com.example.kabarapp.Utils.Utilites.App_ENTRY
import com.example.kabarapp.Utils.Utilites.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserManager(private val Context : Context) : LocalUserManager  {
    override suspend fun saveAppEntry() {
        Context.dataStore.edit { settings ->
            settings[PreferencesKeys.APP_ENTRY] = true
        }
    }

    override suspend fun readAppEntry(): Flow<Boolean> {
        return Context.dataStore.data.map { preferences ->
            preferences[PreferencesKeys.APP_ENTRY] ?: false
        }
    }

}
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)
private object PreferencesKeys {
    val APP_ENTRY = booleanPreferencesKey(name = App_ENTRY)

}