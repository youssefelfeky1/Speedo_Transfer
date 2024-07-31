package com.elfeky.speedo_transfer.ui.authentication

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.data.model.Country
import com.elfeky.speedo_transfer.ui.theme.BlackFieldColor
import com.elfeky.speedo_transfer.ui.theme.BlackText
import com.elfeky.speedo_transfer.ui.theme.DarkRed
import com.elfeky.speedo_transfer.ui.theme.GreyFields
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

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
    var country by remember {
        mutableStateOf("")
    }

    var scaffoldState = // TODO hide the bottom sheet
        rememberBottomSheetScaffoldState(
//            bottomSheetState = rememberStandardBottomSheetState(
//                initialValue = SheetValue.Hidden
//            )
        )


    var date by remember {
        mutableStateOf("DD/MM/YYY")
    }
    var isDatePickerShown by remember {
        mutableStateOf(false)
    }
    var scope = rememberCoroutineScope()

    BottomSheetScaffold(
        sheetContent = { ButtomSheetContent() },
        scaffoldState = scaffoldState,
        sheetShape = RoundedCornerShape(36.dp),
        sheetPeekHeight = 120.dp
    ) { innerPadding ->

        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
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

                Text(text = "Country", color = BlackFieldColor, fontSize = 16.sp)




                OutlinedTextField(
                    value = country,
                    onValueChange = { country = it },
                    enabled = false,
                    readOnly = true,
                    colors = OutlinedTextFieldDefaults.colors(disabledBorderColor = GreyFields),
                    label = { Text(text = "Select your country", color = GreyFields) },
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .clickable {
                            scope.launch { scaffoldState.bottomSheetState.expand() }
                        },

                    trailingIcon = {
                        IconButton(onClick = { scope.launch { scaffoldState.bottomSheetState.expand() } }) {

                            Icon(
                                painter = painterResource(id = R.drawable.chevron_down_1),
                                contentDescription = "select a country ",
                                modifier = modifier.size(24.dp)
                            )
                        }
                    }


                )



                Text(
                    text = "Date Of Brith",
                    color = BlackFieldColor,
                    fontSize = 16.sp,
                    modifier = modifier.padding(bottom = 4.dp)
                )

                OutlinedTextField(
                    value = date,
                    enabled = false,
                    textStyle = TextStyle(color = GreyFields),
                    colors = OutlinedTextFieldDefaults.colors(disabledBorderColor = GreyFields),
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
                    onClick = {
                        navController.navigate("Onboard") {
                            popUpTo("ExtendedSignUp/{name}/{email}/{password}") {
                                inclusive = true
                            }
                        }
                    },
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
    }


}

@Composable
fun ConutryItem(modifier: Modifier = Modifier, country: Country) { // TODO onCardClick
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

@Composable
fun ButtomSheetContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.height(200.dp)) {

        ConutryItem(country = Country(R.drawable.egypt, "Egypt"))
        ConutryItem(country = Country(R.drawable.united_states, "United States"))

    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ExtendedSignUpPreview() {
    ExtendedSignUp("", "", "", navController = rememberNavController())
}