package com.elfeky.speedo_transfer.ui.authentication

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
import com.elfeky.speedo_transfer.ui.authentication.components.EmailTextField
import com.elfeky.speedo_transfer.ui.authentication.components.PasswordTextField
import com.elfeky.speedo_transfer.ui.theme.DarkRed
import com.elfeky.speedo_transfer.ui.theme.BlackFieldColor
import com.elfeky.speedo_transfer.ui.theme.BlackText
import com.elfeky.speedo_transfer.ui.theme.GreyText
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient
import com.elfeky.speedo_transfer.ui.theme.SignUpColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn(modifier: Modifier = Modifier) {


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
            .padding(start = 32.dp, end = 32.dp, top = 32.dp)
            .background(
                brush = Brush.verticalGradient(colors = listOf(Color.White, RoseBottomGradient))
            ),
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


        EmailTextField(email = email)
        Spacer(modifier = modifier.padding(4.dp))

        PasswordTextField(password = password, isPasswordShown = isPasswordShown)

        Spacer(modifier = modifier.padding(12.dp))


        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(7.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DarkRed),

            ) {
            Text(text = "Sign In")

        }

        Row(modifier = modifier.padding(start = 32.dp)) {
            Text(text = "Don’t have an account? ", color = GreyText)
            Text(
                text = "Sign Up",
                color = SignUpColor,
                textDecoration = TextDecoration.Underline
            )
        }


    }


}



@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignInPreview() {

    SignIn()



}