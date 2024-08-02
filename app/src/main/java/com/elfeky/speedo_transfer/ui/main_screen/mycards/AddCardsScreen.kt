package com.elfeky.speedo_transfer.ui.main_screen.mycards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.ui.main_screen.transfer.MainTopAppBar
import com.elfeky.speedo_transfer.ui.theme.GrayG0
import com.elfeky.speedo_transfer.ui.theme.GrayG10
import com.elfeky.speedo_transfer.ui.theme.GrayG70
import com.elfeky.speedo_transfer.ui.theme.GrayG700
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.util.Constants.CONNECTING

@Composable
fun AddCardsScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var cardholderName: String by remember { mutableStateOf("") }
    var cardNo: String by remember { mutableStateOf("") }
    var monthAndYear: String by remember { mutableStateOf("") }
    var cvv: String by remember { mutableStateOf("") }
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
        verticalArrangement = Arrangement.Top
    ) {
        MainTopAppBar(title = "Add Card") {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Sign on your Speedo Transfer \n Account",
                style = MaterialTheme.typography.titleMedium,
                color = GrayG900,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "Cardholder Name",
            fontSize = 16.sp,
            color = GrayG700,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = cardholderName,
            onValueChange = {
                cardholderName = it

            },
            label = { Text(text = "Enter Cardholder Name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = RedP300,
                unfocusedBorderColor = GrayG70,
                unfocusedContainerColor = GrayG10,
                focusedContainerColor = GrayG10,
                focusedLabelColor = RedP300
            ),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Card NO",
            fontSize = 16.sp,
            color = GrayG700,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = cardNo,
            onValueChange = {
                cardNo = it

            },
            label = { Text(text = "Card NO") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = RedP300,
                unfocusedBorderColor = GrayG70,
                unfocusedContainerColor = GrayG10,
                focusedContainerColor = GrayG10,
                focusedLabelColor = RedP300
            ),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = modifier.weight(0.5f)) {
                Text(
                    text = "MM/YY",
                    fontSize = 16.sp,
                    color = GrayG700,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = monthAndYear,
                    onValueChange = {
                        monthAndYear = it

                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = "MM/YY") },
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp)),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = RedP300,
                        unfocusedBorderColor = GrayG70,
                        unfocusedContainerColor = GrayG10,
                        focusedContainerColor = GrayG10,
                        focusedLabelColor = RedP300
                    ),
                    singleLine = true
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = modifier.weight(0.5f)) {
                Text(
                    text = "CVV",
                    fontSize = 16.sp,
                    color = GrayG700,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = cvv,
                    onValueChange = {
                        cvv = it

                    },
                    label = { Text(text = "CVV") },
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp)),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = RedP300,
                        unfocusedBorderColor = GrayG70,
                        unfocusedContainerColor = GrayG10,
                        focusedContainerColor = GrayG10,
                        focusedLabelColor = RedP300
                    ),
                    singleLine = true
                )
            }

        }

        Spacer(modifier = modifier.height(32.dp))
        Button(
            onClick = { navController.navigate(CONNECTING) },
            colors = ButtonDefaults.buttonColors(containerColor = RedP300),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(6.dp),
            enabled = (cardholderName.isNotBlank() && cardholderName.isNotBlank() && monthAndYear.isNotBlank() && cvv.isNotBlank())
        ) {
            Text(
                text = "Sign on",
                color = GrayG0,
                fontSize = 16.sp,
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun MyCardsScreenPreview() {
    AddCardsScreen(navController = rememberNavController())
}