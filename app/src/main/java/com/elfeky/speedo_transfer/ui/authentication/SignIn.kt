package com.elfeky.speedo_transfer.ui.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.ui.authentication.components.EmailTextField
import com.elfeky.speedo_transfer.ui.authentication.components.PasswordTextField
import com.elfeky.speedo_transfer.ui.theme.BlackText
import com.elfeky.speedo_transfer.ui.theme.DarkRed
import com.elfeky.speedo_transfer.ui.theme.GreyText
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient
import com.elfeky.speedo_transfer.ui.theme.SignUpColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn(modifier: Modifier = Modifier, navController: NavController) {


    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var isPasswordShown by remember {
        mutableStateOf(false)
    }
    var validPassword by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .fillMaxSize()

            .background(
                brush = Brush.verticalGradient(colors = listOf(Color.White, RoseBottomGradient))
            )
            .padding(horizontal = 16.dp, vertical = 56.dp),
        verticalArrangement = Arrangement.Top

    ) {
        Text(
            text = "Sign In",
            color = BlackText,
            fontSize = 22.sp,
            modifier = modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelMedium

        )
        Spacer(modifier = modifier.height(64.dp))

        Text(
            text = "Speedo Transfer",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            color = BlackText,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = modifier.height(56.dp))


        EmailTextField {
            email = it
        }
        Spacer(modifier = modifier.height(4.dp))

        PasswordTextField(
            text = "Password",
            isPasswordShown = isPasswordShown,
            onChange = { password = it },
            isPasswordValid = { validPassword = it })


        Spacer(modifier = modifier.height(28.dp))


        Button(
            onClick = {
                navController.navigate("MainScreen") {
                    popUpTo("SignIn") {
                        inclusive = true
                    }
                }
            },
            shape = RoundedCornerShape(7.dp),
            modifier = modifier
                .fillMaxWidth()
                .height(54.dp)
                .padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DarkRed),
            enabled = email.isNotBlank() && password.isNotBlank() && validPassword

        ) {
            Text(text = "Sign In")

        }
        Spacer(modifier = modifier.height(16.dp))

        Row(modifier = modifier.padding(start = 24.dp)) {
            Text(
                text = "Don’t have an account? ", color = GreyText,
                fontSize = 16.sp
            )
            Text(
                text = "Sign Up",
                color = SignUpColor,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { navController.navigate("SignUp") }
            )
        }


    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignInPreview() {

    SignIn(navController = rememberNavController())


}