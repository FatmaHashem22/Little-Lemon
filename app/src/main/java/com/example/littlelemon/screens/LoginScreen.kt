package com.example.littlelemon.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.components.ButtonComponent
import com.example.littlelemon.components.CheckBoxComponent
import com.example.littlelemon.components.ClickableTextOptionComponent
import com.example.littlelemon.components.DividerComponent
import com.example.littlelemon.components.HeaderTextComponent
import com.example.littlelemon.components.NormalTextComponent
import com.example.littlelemon.components.PasswordTextFieldComponent
import com.example.littlelemon.components.TestTextFieldComponent
import com.example.littlelemon.components.TextFieldComponent
import com.example.littlelemon.model.LoginViewModel
import com.example.littlelemon.navigation.Login
import com.example.littlelemon.navigation.SignUp
import com.example.littlelemon.ui.theme.charcoal
import com.example.littlelemon.ui.theme.emailOutlinedIcon
import com.example.littlelemon.ui.theme.green
import com.example.littlelemon.ui.theme.profileOutlinedIcon
import com.example.littlelemon.ui.theme.yellow

@Composable
fun LoginScreen(navController: NavHostController) {

//    val viewModel : LoginViewModel = hiltV

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {

        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            NormalTextComponent(
                value = stringResource(id = R.string.hey_there),
                color = green,
                textAlign = TextAlign.Center
            )

            HeaderTextComponent(
                value = stringResource(id = R.string.welcome),
                color = yellow,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))


//            TestTextFieldComponent(labelValue = stringResource(id = R.string.first_name), imageVector = profileOutlinedIcon ) {
//                viewModel.updateEmail()
//            }
            TextFieldComponent(labelValue = stringResource(id = R.string.email), imageVector = emailOutlinedIcon)

            PasswordTextFieldComponent(labelValue = stringResource(id = R.string.password))

            Spacer(modifier = Modifier.height(8.dp))

//            CheckBoxComponent(navController)
            ClickableTextOptionComponent(
                normalText = "",
                clickableText = stringResource(id = R.string.forgot_password),
                navController = navController,
                destination = SignUp.route

            )

            Spacer(modifier = Modifier.height(100.dp))

            ButtonComponent(
                value = stringResource(id = R.string.login),
                navController = navController,
                destination = Login.route
            )


            Spacer(modifier = Modifier.height(30.dp))

            ClickableTextOptionComponent(
                normalText = stringResource(id = R.string.no_account_yet),
                clickableText = stringResource(id = R.string.register),
                navController = navController,
                destination = SignUp.route

            )

        }

    }

}