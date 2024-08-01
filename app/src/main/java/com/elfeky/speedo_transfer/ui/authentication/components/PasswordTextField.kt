package com.elfeky.speedo_transfer.ui.authentication.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.BlackFieldColor
import com.elfeky.speedo_transfer.ui.theme.GrayG70
import com.elfeky.speedo_transfer.ui.theme.GreyFields


@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    isPasswordShown: Boolean,
    onChange: (String) -> Unit,
    isPasswordValid: (Boolean) -> Unit
) {
    var tempPassword by remember {
        mutableStateOf("")
    }
    var tempIsPasswordShown by remember {
        mutableStateOf(isPasswordShown)
    }
    var passwordConstraintsText by remember {
        mutableStateOf("")
    }

    Text(
        text = "Password",
        color = BlackFieldColor,
        textAlign = TextAlign.Start,
        modifier = modifier.padding(vertical = 6.dp)


    )
    OutlinedTextField(
        value = tempPassword,
        onValueChange = {
            tempPassword = it
            onChange(tempPassword)
            passwordConstraints(tempPassword) { returnedText ->
                passwordConstraintsText = returnedText
            }
            isPasswordValid(passwordConstraintsText == "your password is a strong password \u2714")
        },
        label = { Text(text = "Enter your password ", color = GreyFields) },
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
    val digit = Regex("[0-9]")
    val special = Regex("[!\"#\$%&'()*+,-./:;<=>?@\\]^_`{|}~]")


    val hasLowercaseLetter = lowercaseLetter.containsMatchIn(password)
    val hasUppercaseLetter = uppercaseLetter.containsMatchIn(password)
    val hasDigit = digit.containsMatchIn(password)
    val hasSpecial = special.containsMatchIn(password)
    if (password.isBlank())
        onClick("your password must not be empty")
    else if (password.length < 10)
        onClick("your password must be at least 10 characters long ")
    else if (!hasLowercaseLetter)
        onClick("your password must have at least 1 lowercase letter")
    else if (!hasUppercaseLetter)
        onClick("your password must have at least 1 uppercase letter")
    else if (!hasDigit)
        onClick("your password must have at least 1 digit")
    else if (!hasSpecial)
        onClick("your password must have at least 1 special character")
    else
        onClick("your password is a strong password \u2714")


}