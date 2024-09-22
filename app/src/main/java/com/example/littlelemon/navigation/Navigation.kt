package com.example.littlelemon.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemon.screens.LoginScreen
import com.example.littlelemon.screens.SignUpScreen
import com.example.littlelemon.screens.TermsAndConditionsScreen

@Composable
fun NavigationHandler( navController: NavHostController) {

    NavHost(navController = navController, startDestination = SignUp.route, builder = {
        composable(SignUp.route) {
            SignUpScreen(navController)
        }

        composable(Login.route) {
            LoginScreen(navController)
        }

        composable(TermsAndConditions.route) {
            TermsAndConditionsScreen(navController)
        }
    })

}