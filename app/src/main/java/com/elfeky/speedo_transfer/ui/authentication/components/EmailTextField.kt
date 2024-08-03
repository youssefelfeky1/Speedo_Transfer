

package com.elfeky.speedo_transfer.ui.authentication.components

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.BlackFieldColor
import com.elfeky.speedo_transfer.ui.theme.GrayG10
import com.elfeky.speedo_transfer.ui.theme.GrayG70
import com.elfeky.speedo_transfer.ui.theme.GreyFields
import com.elfeky.speedo_transfer.ui.theme.RedP300

@Composable
fun EmailTextField(modifier: Modifier = Modifier, onChange: (String) -> Unit) {

    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences("user_data" , Context.MODE_PRIVATE)
    val savedEmail = sharedPref.getString("email" , "")
    var textFieldEmail by remember {
        mutableStateOf(savedEmail!!)
    }


    Text(
        text = "Email",
        color = BlackFieldColor,
        textAlign = TextAlign.Start,
        modifier = modifier.padding(vertical = 6.dp)


    )
    OutlinedTextField(
        value = textFieldEmail,
        onValueChange = {
            textFieldEmail = it
            onChange(it)
        },
        label = { Text(text = "Enter your email address", color = GreyFields) },
        maxLines = 1,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = RedP300,
            unfocusedBorderColor = GrayG70,
            unfocusedContainerColor = GrayG10,
            focusedContainerColor = GrayG10,
            focusedLabelColor = RedP300
        ),
        shape = RoundedCornerShape(7.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.email_1),
                contentDescription = "email icon",
                modifier = Modifier.size(24.dp),
                tint = GrayG70
            )
        }


    )


}