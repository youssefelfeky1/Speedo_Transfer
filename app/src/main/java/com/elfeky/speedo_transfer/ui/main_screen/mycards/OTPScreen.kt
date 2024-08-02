package com.elfeky.speedo_transfer.ui.main_screen.mycards

import androidx.compose.foundation.background
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.ui.main_screen.mycards.components.OtpTextField
import com.elfeky.speedo_transfer.ui.main_screen.transfer.MainTopAppBar
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.util.Constants.ACCOUNT_CONNECTING_SCREEN


@Composable
fun OTPScreen(
    navController: NavController, modifier: Modifier = Modifier
) {
    var otpValue by remember { mutableStateOf("") }
    var otpInputFilled by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color(0xFFFFEAEE)
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 44.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        MainTopAppBar(title ="Bank Card OTP") {
            navController.popBackStack()
        }

        Spacer(modifier = Modifier.height(45.dp))
        Text(
            text = "Enter the digits verification code send to Email@gmail.com",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        var otpValue by remember {
            mutableStateOf("")
        }


        OtpTextField(
            otpText = otpValue,
            onOtpTextChange = { value,filled ->
                otpValue = value
                otpInputFilled = filled
            }
        )
        Spacer(modifier = Modifier.height(48.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Don’t receive OTP?",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontSize = 16.sp
            )
            Text(
                text = "  Resend OTP",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color = RedP300,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.padding(120.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            onClick = { navController.navigate(ACCOUNT_CONNECTING_SCREEN) },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (otpInputFilled) RedP300 else Color(0xFF898886)
            ),
            enabled = otpInputFilled,
            shape = RoundedCornerShape(size = 8.dp)
        ) {
            Text(
                text = "Submit Refill", fontSize = 16.sp
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun OTPPreview() {
    OTPScreen(navController = rememberNavController())
}