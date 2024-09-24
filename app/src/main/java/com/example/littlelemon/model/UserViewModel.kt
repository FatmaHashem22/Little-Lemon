package com.example.littlelemon.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UserViewModel(
    private val dataStore: DataStore<Preferences>
) : ViewModel() {

    private val _user = mutableStateOf<User?>(null)
    val user: State<User?> = _user

    fun signUp(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            dataStore.edit { preference ->
                preference[PreferencesKey.FIRST_NAME] = firstName
                preference[PreferencesKey.LAST_NAME] = lastName
                preference[PreferencesKey.EMAIL] = email
                preference[PreferencesKey.PASSWORD] = password
            }
            _user.value = User(firstName, lastName, email, password)
        }
    }

    private suspend fun getUser(): User? {
        dataStore.data.first().let { preferences ->
            val firstName = preferences[PreferencesKey.FIRST_NAME] ?: ""
            val lastName = preferences[PreferencesKey.LAST_NAME] ?: ""
            val email = preferences[PreferencesKey.EMAIL] ?: ""
            val password = preferences[PreferencesKey.PASSWORD] ?: ""

            if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty())
                return User(firstName,lastName, email, password)
            else return null
        }
    }

    suspend fun login(email: String, password: String) : Boolean {
        val isAuthorized = viewModelScope.async {
            val storedUser = getUser()
            storedUser != null && storedUser.email == email && storedUser.password == password
        }.await()
        return isAuthorized
    }



}