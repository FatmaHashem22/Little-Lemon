package com.example.littlelemon.navigation

import androidx.compose.ui.res.stringResource
import com.example.littlelemon.R

interface Destinations {
    val route : String
}

object Splash : Destinations {
    override val route: String = "Splash"

}

object SignUp : Destinations {
    override val route: String = "SignUp"

}

object Login : Destinations {
    override val route: String = "Login"

}

object TermsAndConditions : Destinations {
    override val route: String = "TermsAndConditions"

}
