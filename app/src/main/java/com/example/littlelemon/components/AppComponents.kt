package com.example.littlelemon.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.navigation.Destinations
import com.example.littlelemon.navigation.TermsAndConditions
import com.example.littlelemon.ui.theme.accentYellow
import com.example.littlelemon.ui.theme.charcoal
import com.example.littlelemon.ui.theme.gray
import com.example.littlelemon.ui.theme.hidePasswordIcon
import com.example.littlelemon.ui.theme.lightGray
import com.example.littlelemon.ui.theme.passwordOutlinedIcon
import com.example.littlelemon.ui.theme.showPasswordIcon
import com.example.littlelemon.ui.theme.yellow

@Composable
fun NormalTextComponent(value: String, color: Color, textAlign: TextAlign) {
    Text(
        text = value,
        color = color,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.SansSerif,
        textAlign = textAlign
    )
}

@Composable
fun HeaderTextComponent(value: String, color: Color, textAlign: TextAlign) {
    Text(
        text = value,
        color = color,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.SansSerif,
        textAlign = textAlign
    )

}

@Composable
fun TextFieldComponent(labelValue: String, imageVector: ImageVector) {

    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = textValue.value,
        label = { Text(text = labelValue) },
        modifier = Modifier
            .fillMaxWidth(),
        onValueChange = { textValue.value = it },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = yellow,
            unfocusedBorderColor = lightGray,
            cursorColor = yellow,
            focusedContainerColor = lightGray,
            unfocusedContainerColor = lightGray,
            unfocusedLeadingIconColor = gray,
            focusedLeadingIconColor = yellow
        ),
        keyboardOptions = KeyboardOptions.Default,
        shape = RoundedCornerShape(22.dp),
        leadingIcon = { Icon(imageVector = imageVector, contentDescription = "") }

    )
}

@Composable
fun PasswordTextFieldComponent(labelValue: String) {

    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = password.value,
        label = { Text(text = labelValue) },
        modifier = Modifier
            .fillMaxWidth(),
        onValueChange = { password.value = it },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = yellow,
            unfocusedBorderColor = lightGray,
            cursorColor = yellow,
            focusedContainerColor = lightGray,
            unfocusedContainerColor = lightGray,
            unfocusedLeadingIconColor = gray,
            focusedLeadingIconColor = yellow,
            unfocusedTrailingIconColor = gray,
            focusedTrailingIconColor = yellow
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        shape = RoundedCornerShape(22.dp),
        leadingIcon = { Icon(imageVector = passwordOutlinedIcon, contentDescription = "") },
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                showPasswordIcon
            } else {
                hidePasswordIcon
            }

            val description = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()


    )
}

@Composable
fun CheckBoxComponent(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = !checkedState.value },
            colors = CheckboxDefaults.colors(
                checkedColor = yellow,
                uncheckedColor = gray,
                checkmarkColor = yellow
            )
        )

        ClickableTextComponent(navController)

    }
}

@Composable
fun ClickableTextComponent(navController: NavHostController) {

    Text(text = stringResource(id = R.string.initial_policy_text), color = gray)
    Text(
        text = stringResource(id = R.string.last_policy_text),
        color = gray,
        fontWeight = FontWeight.SemiBold,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier.clickable {
            navController.navigate(TermsAndConditions.route)
        }
    )
}


@Composable
fun ClickableTextOptionComponent(normalText : String, clickcableText: String, navController: NavHostController, destination: String) {

    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(text = normalText, color = charcoal,fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = clickcableText,
            color = gray,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable {
                navController.navigate(destination)
            }
        )
    }


}

@Composable
fun ButtonComponent(value: String, navController: NavHostController, destination: String) {
    Button(
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        onClick = { navController.navigate(destination) },
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(yellow, accentYellow)),
                    shape = RoundedCornerShape(50.dp),
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }

    }
}

@Composable
fun DividerComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 8.dp, start = 8.dp, end = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Divider(
            color = gray, thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        )
        Text(
            text = "Or",
            color = charcoal,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )
        Divider(
            color = gray, thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        )

    }
}