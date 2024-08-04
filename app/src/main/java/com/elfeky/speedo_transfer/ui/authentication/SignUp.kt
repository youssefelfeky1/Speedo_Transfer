package com.elfeky.speedo_transfer.ui.authentication

import android.util.Log
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.authentication.components.EmailTextField
import com.elfeky.speedo_transfer.ui.authentication.components.PasswordTextField
import com.elfeky.speedo_transfer.ui.authentication.components.passwordConstraints
import com.elfeky.speedo_transfer.ui.theme.BlackFieldColor
import com.elfeky.speedo_transfer.ui.theme.BlackText
import com.elfeky.speedo_transfer.ui.theme.DarkRed
import com.elfeky.speedo_transfer.ui.theme.GrayG10
import com.elfeky.speedo_transfer.ui.theme.GrayG70
import com.elfeky.speedo_transfer.ui.theme.GreyFields
import com.elfeky.speedo_transfer.ui.theme.GreyText
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient
import com.elfeky.speedo_transfer.ui.theme.SignUpColor

@Composable
fun SignUp(modifier: Modifier = Modifier, navController: NavController) {

    var name by remember {
        mutableStateOf("")
    }

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
            .padding(horizontal = 16.dp, vertical = 36.dp),
        verticalArrangement = Arrangement.Top

    ) {
        Text(
            text = "Sign Up",
            color = BlackText,
            fontSize = 24.sp,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 20.dp),
            textAlign = TextAlign.Center

        )
        Spacer(modifier = modifier.padding(20.dp))

        Text(
            text = "Speedo Transfer",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = BlackText,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center


        )
        Spacer(modifier = modifier.padding(32.dp))


        Text(
            text = "Full Name",
            color = BlackFieldColor,
            textAlign = TextAlign.Start,
            modifier = modifier.padding(bottom = 4.dp)

        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            shape = RoundedCornerShape(7.dp),
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = RedP300,
                unfocusedBorderColor = GrayG70,
                unfocusedContainerColor = GrayG10,
                focusedContainerColor = GrayG10,
                focusedLabelColor = RedP300,
                unfocusedLabelColor = GreyFields

            ),
            label = { Text(text = "Enter your Full Name") },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.user_1),
                    contentDescription = "profile icon",
                    modifier = Modifier.size(24.dp)
                )
            }


        )

        EmailTextField {
            email = it
        }
        PasswordTextField(
            text = "Password",
            isPasswordShown = isPasswordShown,
            onChange = { password = it },
            isPasswordValid = { validPassword = it })


        Spacer(modifier = modifier.padding(12.dp))


        Button(
            onClick = {
                Log.d("test", "$name/$email/$password")
                navController.navigate("ExtendedSignUp/$name/$email/$password") {
                    popUpTo("SignUp") {
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
            enabled = name.isNotBlank() && email.isNotBlank() && password.isNotBlank() && validPassword

        ) {
            Text(text = "Sign Up")

        }

        Row(modifier = modifier.padding(start = 32.dp)) {
            Text(text = "Already have an account? ", color = GreyText)
            Text(
                text = "Sign In",
                color = SignUpColor,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { navController.navigate("SignIn") }
            )
        }


    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignUpPreview() {
    SignUp(navController = rememberNavController())


}


