package com.example.littlelemon.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.navigation.NavigationHandler
import com.example.littlelemon.screens.SignUpScreen

@Composable
fun LittleLemonApp(){
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val navController = rememberNavController()
        NavigationHandler(navController = navController)
    }
}