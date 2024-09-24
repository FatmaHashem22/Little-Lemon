package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import com.example.littlelemon.app.LittleLemonApp
import com.example.littlelemon.utils.DataStoreManager


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
