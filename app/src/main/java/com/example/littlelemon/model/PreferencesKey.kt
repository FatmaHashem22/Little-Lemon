package com.example.littlelemon.model

import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKey {
    val FIRST_NAME = stringPreferencesKey("firstName")
    val LAST_NAME = stringPreferencesKey("lastName")
    val EMAIL = stringPreferencesKey("email")
    val PASSWORD = stringPreferencesKey("password")
}