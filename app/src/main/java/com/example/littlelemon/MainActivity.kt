package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.example.littlelemon.app.LittleLemonApp
import com.example.littlelemon.model.LoginViewModel
import com.example.littlelemon.utils.DataStoreManager
import com.example.littlelemon.utils.preferenceDataStore


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val dataStoreContext = LocalContext.current
            val dataStoreManager = DataStoreManager(dataStoreContext)
            LittleLemonApp()
        }
    }
}
