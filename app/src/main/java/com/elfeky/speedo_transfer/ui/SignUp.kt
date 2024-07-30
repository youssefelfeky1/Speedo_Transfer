package com.elfeky.speedo_transfer.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.DarkRed
import com.elfeky.speedo_transfer.ui.theme.BlackFieldColor
import com.elfeky.speedo_transfer.ui.theme.BlackText
import com.elfeky.speedo_transfer.ui.theme.GreyText
import com.elfeky.speedo_transfer.ui.theme.SignUpColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(modifier: Modifier = Modifier) {

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
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 32.dp, end = 32.dp, top = 32.dp),
        verticalArrangement = Arrangement.Top

    ) {
        Text(
            text = "Sign Up",
            color = BlackText,
            fontSize = 24.sp,
            modifier = modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth(),
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
            label = { Text(text = "Enter your Full Name") },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.user_1),
                    contentDescription = "profile icon"
                )
            }


        )


        Text(
            text = "Email",
            color = BlackFieldColor,
            textAlign = TextAlign.Start,
            modifier = modifier.padding(vertical = 6.dp)


        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Enter your email address") },
            shape = RoundedCornerShape(7.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.email_1),
                    contentDescription = "email icon"
                )
            }


        )


        Text(
            text = "Password",
            color = BlackFieldColor,
            textAlign = TextAlign.Start,
            modifier = modifier.padding(vertical = 6.dp)


        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Enter your password ") },
            shape = RoundedCornerShape(7.dp),
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (isPasswordShown) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

            trailingIcon = {
                val id = if (!isPasswordShown) R.drawable.open_eye else R.drawable.close_eye
                IconButton(onClick = { isPasswordShown = !isPasswordShown }) {
                    Icon(
                        painter = painterResource(id = id),
                        contentDescription = "password icon"
                    )
                }
            }


        )
        Spacer(modifier = modifier.padding(12.dp))


        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(7.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DarkRed),

            ) {
            Text(text = "Sign Up")

        }

        Row(modifier = modifier.padding(start = 32.dp)) {
            Text(text = "Already have an account? ", color = GreyText)
            Text(
                text = "Sign In",
                color = SignUpColor,
                textDecoration = TextDecoration.Underline
            )
        }


    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignUpPreview() {
    SignUp()


}