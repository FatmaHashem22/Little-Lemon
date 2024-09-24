package com.example.littlelemon.model

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel

class LoginViewModel(
    private val dataStore: DataStore<Preferences>
) : ViewModel() {



}