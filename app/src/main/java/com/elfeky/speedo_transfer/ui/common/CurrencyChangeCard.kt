package com.elfeky.speedo_transfer.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.GrayG40
import com.elfeky.speedo_transfer.ui.theme.RedP300


@Composable
fun CurrencyConverter(
    amount: MutableState<String>
) {

    var amountInEgp by remember { mutableStateOf("0.00") }

    val conversionRate = 48.4

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth(), colors = CardDefaults.cardColors(Color.White)

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "1 USD = 48.4220 EGP", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Rate guaranteed (2h)", fontSize = 12.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "You Send", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                CurrencyDropDown("EGP", R.drawable.egypt)
                Spacer(modifier = Modifier.weight(1f))
                OutlinedTextField(
                    value = amount.value,
                    onValueChange = {
                        if (it.isDigitsOnly()) {
                            amount.value = it
                            val usdValue = it.toDoubleOrNull() ?: 0.0
                            amountInEgp = (usdValue / conversionRate).toString()
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                    maxLines = 1,
                    modifier = Modifier
                        .width(160.dp)
                        .height(52.dp),
                    textStyle = TextStyle(
                        fontSize = 20.sp, fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    ),
                    colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = RedP300)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(
                color = GrayG40,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Recipient Gets", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                CurrencyDropDown("USD", R.drawable.united_states)
                Spacer(modifier = Modifier.weight(1f))
                OutlinedTextField(
                    value = amountInEgp,
                    onValueChange = {
                        if (it.isDigitsOnly()) {
                            amountInEgp = it
                            val egpValue = it.toDoubleOrNull() ?: 0.0
                            amount.value = (egpValue * conversionRate).toString()
                        }
                    },
                    readOnly = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                    maxLines = 1,
                    modifier = Modifier
                        .width(160.dp)
                        .height(52.dp),
                    colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = RedP300),
                    textStyle = TextStyle(
                        fontSize = 20.sp, fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )
                )
            }


        }
    }
}


@Composable
fun CurrencyDropDown(selectedCurrency: String, @DrawableRes icon: Int) {
    var expanded by remember { mutableStateOf(false) }
    val currencies = listOf("USD", "EGP")
    var selected by remember { mutableStateOf(selectedCurrency) }

    Box {
        Row(

            modifier = Modifier
                .width(160.dp)
                .height(46.dp)
                .clickable { expanded = true }, verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "country icon",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 4.dp)
                )
                Text(
                    text = selected,
                    color = RedP300,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    modifier = Modifier

                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    painter = painterResource(id = R.drawable.chevron_down_1),
                    contentDescription = null,
                )
            }

        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            currencies.forEach { currency ->
                DropdownMenuItem(
                    text = { currency },
                    onClick = {
                        selected = currency
                        expanded = false
                    })
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun CurrencyConverterPreview() {
//    CurrencyConverter(amount = mutableStateOf(""))
//}
