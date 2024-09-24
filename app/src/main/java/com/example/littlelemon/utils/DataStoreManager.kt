package com.example.littlelemon.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.littlelemon.model.PreferencesKey
import com.example.littlelemon.model.User
import kotlinx.coroutines.flow.map


const val USER_DATASTORE = "user_data"

val Context.preferenceDataStore : DataStore<Preferences> by preferencesDataStore(name = USER_DATASTORE)
class DataStoreManager (
    val context: Context
){

    suspend fun saveToDataStore(user: User) {
        context.preferenceDataStore.edit {
            it[PreferencesKey.FIRST_NAME] = user.firstName
            it[PreferencesKey.LAST_NAME] = user.lastName
            it[PreferencesKey.EMAIL] = user.email
            it[PreferencesKey.PASSWORD] = user.password
        }
    }

    fun getFromDataStore () = context.preferenceDataStore.data.map {
        User(
            email = it[PreferencesKey.EMAIL]?:""
        )
    }

    suspend fun clearDataStore() = context.preferenceDataStore.edit {
        it.clear()
    }
}