package com.test.newsjeptackcompose.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.test.newsjeptackcompose.domain.manager.LocalUserManger
import kotlinx.coroutines.flow.Flow
import androidx.datastore.preferences.preferencesDataStore
import com.test.newsjeptackcompose.data.constants.Constants
import com.test.newsjeptackcompose.data.constants.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.map


class LocalUserMangerImpl(
    private val context: Context
) : LocalUserManger {

    private val readOnlyProperty = preferencesDataStore(name = USER_SETTINGS)
    val Context.dataStore: DataStore<Preferences> by readOnlyProperty
    private object PreferenceKeys {
        val APP_ENTRY = booleanPreferencesKey(Constants.APP_ENTRY)
    }

    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferenceKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferenceKeys.APP_ENTRY] ?: false
        }
    }
}