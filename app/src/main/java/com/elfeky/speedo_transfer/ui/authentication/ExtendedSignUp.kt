package com.elfeky.speedo_transfer.ui.authentication

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
import com.elfeky.speedo_transfer.data.model.Country
import com.elfeky.speedo_transfer.ui.theme.DarkRed
import com.elfeky.speedo_transfer.ui.theme.BlackFieldColor
import com.elfeky.speedo_transfer.ui.theme.BlackText
import com.elfeky.speedo_transfer.ui.theme.GreyFields
import com.elfeky.speedo_transfer.ui.theme.GreyText
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient
import com.elfeky.speedo_transfer.ui.theme.SignUpColor
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExtendedSignUp(modifier: Modifier = Modifier) {
    var country by remember {
        mutableStateOf("")
    }

    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by remember {
        mutableStateOf(false)
    }

    var date by remember {
        mutableStateOf("DD/MM/YYY")
    }
    var isDatePickerShown by remember {
        mutableStateOf(false)
    }




    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 32.dp, end = 32.dp, top = 88.dp)
            .background(
                brush = Brush.verticalGradient(colors = listOf(Color.White, RoseBottomGradient))
            ),
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

        Text(text = "Country", color = BlackFieldColor, fontSize = 16.sp)




        OutlinedTextField(
            value = country,
            onValueChange = { country = it },
            shape = RoundedCornerShape(7.dp),
            label = { Text(text = "Select your country", color = GreyFields) },
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),

            trailingIcon = {
                IconButton(onClick = { isSheetOpen = true }) {

                    Icon(
                        painter = painterResource(id = R.drawable.chevron_down_1),
                        contentDescription = "select a country "
                    )
                }
            }


        )

        if (isSheetOpen) {
            ModalBottomSheet(sheetState = sheetState, onDismissRequest = { isSheetOpen = false }) {
                ConutryItem(country = Country(R.drawable.egypt, "Egypt"))
                ConutryItem(country = Country(R.drawable.united_states, "United States"))


            }
        }

        Text(
            text = "Date Of Brith",
            color = BlackFieldColor,
            fontSize = 16.sp,
            modifier = modifier.padding(bottom = 4.dp)
        )

        OutlinedTextField(
            value = date,
            textStyle = TextStyle(color = GreyFields),
            onValueChange = { date = it },
            shape = RoundedCornerShape(7.dp),
//            label = { Text(text = date  , color = GreyFields) },
            modifier = modifier
                .fillMaxWidth(),
            readOnly = true,

            trailingIcon = {

                IconButton(onClick = { isDatePickerShown = true }) {

                    Icon(
                        painter = painterResource(id = R.drawable.calender),
                        contentDescription = "select a date ",
                        modifier = modifier.size(24.dp)
                    )
                }

            }


        )
        if (isDatePickerShown) {
            DatePickerChooser(onConfirm = {
                var c = Calendar.getInstance()
                c.timeInMillis =
                    it.selectedDateMillis!! // calender class is used to convert from ms to date
                var dateFormatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)

                date = dateFormatter.format(c.time)

                isDatePickerShown = false
            }, onDismiss = {
                isDatePickerShown = false
            })
        }








        Spacer(modifier = modifier.padding(12.dp))


        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(7.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DarkRed),

            ) {
            Text(text = "Continue")

        }

    }
}

@Composable
fun ConutryItem(modifier: Modifier = Modifier, country: Country) {
    Card(
        onClick = { /*TODO*/ }, modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = modifier
                .height(20.dp)
                .background(Color.White)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = country.picture),
                contentDescription = "Egypt",
                modifier = modifier.padding(start = 8.dp)
            )
            Text(text = country.name, modifier = modifier.padding(start = 8.dp))

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerChooser(onConfirm: (DatePickerState) -> Unit, onDismiss: () -> Unit) {
    val datePickerState =
        rememberDatePickerState(initialSelectedDateMillis = System.currentTimeMillis())
    DatePickerDialog(onDismissRequest = {},
        confirmButton = {
            TextButton(onClick = { onConfirm(datePickerState) }) {
                Text(text = "Ok")

            }


        },
        dismissButton = {

            TextButton(onClick = { onDismiss() }) {
                Text(text = "Cancel")

            }
        }

    ) {
        DatePicker(state = datePickerState)
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ExtendedSignUpPreview() {
    ExtendedSignUp()


}