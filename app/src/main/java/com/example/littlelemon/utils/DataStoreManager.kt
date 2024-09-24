package com.example.littlelemon.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.littlelemon.model.UserDetails
import kotlinx.coroutines.flow.map


const val USER_DATASTORE = "user_data"

val Context.preferenceDataStore : DataStore<Preferences> by preferencesDataStore(name = USER_DATASTORE)
class DataStoreManager (
    val context: Context
){

    companion object {
        val FIRST_NAME = stringPreferencesKey("firstName")
        val LAST_NAME = stringPreferencesKey("lastName")
        val EMAIL = stringPreferencesKey("email")
        val PASSWORD = stringPreferencesKey("password")
    }

    suspend fun saveToDataStore(userDetails: UserDetails) {
        context.preferenceDataStore.edit {
            it[FIRST_NAME] = userDetails.firstName
            it[LAST_NAME] = userDetails.lastName
            it[EMAIL] = userDetails.email
            it[PASSWORD] = userDetails.password
        }
    }

    fun getFromDataStore () = context.preferenceDataStore.data.map {
        UserDetails(
            email = it[EMAIL]?:""
        )
    }

    suspend fun clearDataStore() = context.preferenceDataStore.edit {
        it.clear()
    }
}