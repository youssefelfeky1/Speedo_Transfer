package com.elfeky.speedo_transfer.ui.authentication.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.BlackFieldColor
import com.elfeky.speedo_transfer.ui.theme.GrayG10
import com.elfeky.speedo_transfer.ui.theme.GreyFields
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTextField(modifier: Modifier = Modifier, onClick: (String) -> Unit) {

    var date by remember {
        mutableStateOf("")
    }
    var isDatePickerShown by remember {
        mutableStateOf(false)
    }





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
        colors = OutlinedTextFieldDefaults.colors(
            disabledBorderColor = GreyFields,
            disabledContainerColor = GrayG10
        ),
        onValueChange = { date = it },
        shape = RoundedCornerShape(7.dp),
        label = { Text(text = "DD/MM/YYYY", color = GreyFields) },
        modifier = modifier
            .fillMaxWidth()
            .clickable { isDatePickerShown = true },
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
            onClick(date)

            isDatePickerShown = false
        }, onDismiss = {
            isDatePickerShown = false
        })
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
