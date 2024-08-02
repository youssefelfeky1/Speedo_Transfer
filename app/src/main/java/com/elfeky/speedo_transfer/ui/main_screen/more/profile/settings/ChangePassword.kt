package com.elfeky.speedo_transfer.ui.main_screen.more.profile.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elfeky.speedo_transfer.ui.authentication.components.PasswordTextField
import com.elfeky.speedo_transfer.ui.main_screen.more.profile.components.TopAppBarSection
import com.elfeky.speedo_transfer.ui.theme.DarkRed
import com.elfeky.speedo_transfer.ui.theme.YellowTopGradient


@Composable
fun ChangePassword(modifier: Modifier = Modifier) {
    
    var currentPassword by remember {
        mutableStateOf("")
    }
    var newPassword by remember {
        mutableStateOf("")
    }

    var isNewPasswordValid by remember {
        mutableStateOf(false)
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
        TopAppBarSection(text = "Change Password")
        Spacer(modifier = modifier.padding(16.dp))
        PasswordTextField(text = "Current Password",isPasswordShown = false, onChange = { currentPassword = it }) {
            
        }

         PasswordTextField(text = "New Password",isPasswordShown = false, onChange = { newPassword = it }) {

             isNewPasswordValid = it


        }


        Button(
            onClick = {
                //TODO
            },
            shape = RoundedCornerShape(7.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DarkRed),
            enabled = currentPassword.isNotBlank() && newPassword.isNotBlank() && isNewPasswordValid

        ) {
            Text(text = "Save")

        }

    }


}


@Preview
@Composable
private fun ChangePasswordPreview() {
    ChangePassword()

}
