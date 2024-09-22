package com.example.littlelemon.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.components.HeaderTextComponent
import com.example.littlelemon.navigation.SignUp
import com.example.littlelemon.ui.theme.backButtonIcon
import com.example.littlelemon.ui.theme.charcoal

@Composable
fun TermsAndConditionsScreen(navController: NavHostController) {
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 28.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            Row (
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { navController.navigate(SignUp.route) }) {
                    Icon(imageVector = backButtonIcon , contentDescription = "BackButton")
                }
                HeaderTextComponent(
                    value = stringResource(id = R.string.terms_and_conditions_header),
                    color = charcoal,
                    textAlign = TextAlign.Center
                )
            }

        }



    }
}
