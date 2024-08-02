package com.elfeky.speedo_transfer.ui.main_screen.more.profile.settings

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.authentication.components.CountryTextField
import com.elfeky.speedo_transfer.ui.authentication.components.DateTextField
import com.elfeky.speedo_transfer.ui.authentication.components.EmailTextField
import com.elfeky.speedo_transfer.ui.main_screen.more.profile.components.TopAppBarSection
import com.elfeky.speedo_transfer.ui.main_screen.transfer.MainTopAppBar
import com.elfeky.speedo_transfer.ui.theme.BlackFieldColor
import com.elfeky.speedo_transfer.ui.theme.DarkRed
import com.elfeky.speedo_transfer.ui.theme.GrayG10
import com.elfeky.speedo_transfer.ui.theme.GrayG70
import com.elfeky.speedo_transfer.ui.theme.GreyFields
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.ui.theme.YellowTopGradient

@Composable
fun EditProfile(modifier: Modifier = Modifier , navController: NavController) {

    var name by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

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
                        YellowTopGradient,
                        Color(0xFFFFEAEE)
                    )
                )
            )
            .padding(16.dp)
    ) {
        MainTopAppBar(title = "Edit Profile"){
            navController.popBackStack()

        }
        Spacer(modifier = modifier.padding(16.dp))

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
                focusedLabelColor = RedP300
            ),
            label = { Text(text = "Enter Cardholder Name", color = GreyFields) },
            modifier = Modifier.fillMaxWidth(),


            )
        Spacer(modifier = modifier.padding(6.dp))
        EmailTextField {
            email = it

        }
        Spacer(modifier = modifier.padding(6.dp))

        CountryTextField {
            countryName = it
        }

        DateTextField {
            date = it
        }

        Spacer(modifier = modifier.padding(12.dp))


        Button(
            onClick = {
                //TODO
            },
            shape = RoundedCornerShape(7.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DarkRed),
            enabled = name.isNotBlank() && email.isNotBlank() && date.isNotBlank() && countryName.isNotBlank()

        ) {
            Text(text = "Save")

        }


    }
}

@Preview
@Composable
private fun EditProfilePreview() {
    EditProfile(navController = rememberNavController())
}