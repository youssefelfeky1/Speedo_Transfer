
package com.elfeky.speedo_transfer.ui.authentication.components

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.BlackFieldColor
import com.elfeky.speedo_transfer.ui.theme.GrayG10
import com.elfeky.speedo_transfer.ui.theme.GrayG70
import com.elfeky.speedo_transfer.ui.theme.GreyFields
import com.elfeky.speedo_transfer.ui.theme.RedP300


@Composable
fun PasswordTextField(

    modifier: Modifier = Modifier,
    text: String,
    isPasswordShown: Boolean,
    onChange: (String) -> Unit,
    isPasswordValid: (Boolean) -> Unit
) {
    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences("user_data" , Context.MODE_PRIVATE)
    val savedPassword = sharedPref.getString("password" , "")
    var isSavedPasswordFound = (savedPassword!="")
    var tempPassword by remember {
        mutableStateOf(savedPassword!!)
    }

    var tempIsPasswordShown by remember {
        mutableStateOf(isPasswordShown)
    }
    var passwordConstraintsText by remember {
        mutableStateOf("")
    }
    isPasswordValid(isSavedPasswordFound || passwordConstraintsText == "your password is a strong password \u2714")

    Text(
        text = text,
        color = BlackFieldColor,
        textAlign = TextAlign.Start,
        modifier = modifier.padding(vertical = 6.dp)


    )
    OutlinedTextField(
        value = tempPassword,
        onValueChange = {
            tempPassword = it
            onChange(tempPassword)
            if (text != "Current Password") {
                passwordConstraints(tempPassword) { returnedText ->
                    passwordConstraintsText = returnedText
                }
            }
        },
        label = { Text(text = "Enter your password ", color = GreyFields) },
        maxLines = 1,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = RedP300,
            unfocusedBorderColor = GrayG70,
            unfocusedContainerColor = GrayG10,
            focusedContainerColor = GrayG10,
            focusedLabelColor = RedP300
        ),
        shape = RoundedCornerShape(7.dp),
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = if (tempIsPasswordShown) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

        trailingIcon = {
            val id = if (!tempIsPasswordShown) R.drawable.open_eye else R.drawable.close_eye
            IconButton(onClick = { tempIsPasswordShown = !tempIsPasswordShown }) {
                Icon(
                    painter = painterResource(id = id),
                    contentDescription = "password icon",
                    modifier = Modifier.size(24.dp),
                    tint = GrayG70
                )
            }
        }


    )

    Text(text = passwordConstraintsText, color = Color.Red)

}


fun passwordConstraints(password: String, onClick: (String) -> Unit) {
    val lowercaseLetter = Regex("[a-z]")
    val uppercaseLetter = Regex("[A-Z]")
    val special = Regex("[!\"#\$%&'()*+,-./:;<=>?@\\]^_`{|}~]")


    val hasLowercaseLetter = lowercaseLetter.containsMatchIn(password)
    val hasUppercaseLetter = uppercaseLetter.containsMatchIn(password)
    val hasSpecial = special.containsMatchIn(password)
    if (password.isBlank())
        onClick("your password must not be empty")
    else if (password.length < 6)
        onClick("your password must be at least 6 characters long ")
    else if (!hasLowercaseLetter)
        onClick("your password must have at least 1 lowercase letter")
    else if (!hasUppercaseLetter)
        onClick("your password must have at least 1 uppercase letter")
    else if (!hasSpecial)
        onClick("your password must have at least 1 special character")
    else
        onClick("your password is a strong password \u2714")
}
