package com.elfeky.speedo_transfer.ui.authentication

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.ui.authentication.components.CountryTextField
import com.elfeky.speedo_transfer.ui.authentication.components.DateTextField
import com.elfeky.speedo_transfer.ui.theme.BlackFieldColor
import com.elfeky.speedo_transfer.ui.theme.BlackText
import com.elfeky.speedo_transfer.ui.theme.DarkRed
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExtendedSignUp(
    name: String,
    email: String,
    password: String,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var countryName by remember {
        mutableStateOf("")
    }

    var date by remember {
        mutableStateOf("")
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        RoseBottomGradient
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 36.dp),
        verticalArrangement = Arrangement.Top

    ) {


        Spacer(modifier = modifier.padding(20.dp))

        Text(
            text = "Speedo Transfer",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = BlackText,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center


        )
        Spacer(modifier = modifier.padding(28.dp))

        Text(
            text = "Welcome to Banque Misr!",
            color = BlackText,
            modifier = modifier
                .padding(bottom = 6.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center

        )
        Spacer(modifier = modifier.padding(6.dp))


        Text(
            text = "Let’s Complete your Profile",
            color = BlackFieldColor,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,


            )
        Spacer(modifier = modifier.padding(16.dp))
        CountryTextField {
            countryName = it
        }

        DateTextField {
            date = it
        }



        Spacer(modifier = modifier.padding(12.dp))


        Button(
            onClick = {
                navController.navigate("Onboard") {
                    popUpTo("ExtendedSignUp/{name}/{email}/{password}") {
                        inclusive = true
                    }
                }
            },
            shape = RoundedCornerShape(8.dp),
            modifier = modifier
                .fillMaxWidth()
                .height(50.dp)
            ,
            colors = ButtonDefaults.buttonColors(containerColor = DarkRed),
            enabled = date.isNotBlank() && countryName.isNotBlank()

            ) {
            Text(text = "Continue")

        }


    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ExtendedSignUpPreview() {
    ExtendedSignUp("", "", "", navController = rememberNavController())
}