package com.example.littlelemon.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.littlelemon.components.HeaderTextComponent
import com.example.littlelemon.ui.theme.charcoal

@Composable
fun LoginScreen(navController: NavHostController) {

    Surface (
        modifier = Modifier.fillMaxSize()
    ) {

        HeaderTextComponent(value = "Login", color = charcoal, textAlign = TextAlign.Center)

    }

}