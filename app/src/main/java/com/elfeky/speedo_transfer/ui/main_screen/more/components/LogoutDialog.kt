package com.elfeky.speedo_transfer.ui.main_screen.more.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elfeky.speedo_transfer.ui.theme.DarkRed
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient


@Composable
fun AlertDialogLogout(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        containerColor = RoseBottomGradient,
        onDismissRequest = onDismiss,
        text = {
            Text("Are you sure you want to logout?", color = DarkRed)
        },
        confirmButton = {
            Button(
                onClick = onConfirm,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                   ,
                colors = ButtonDefaults.buttonColors(DarkRed)


            ) {
                Text("Confirm", color = Color.White)
            }
        },
        dismissButton = {
            OutlinedButton(
                onClick = onDismiss,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .background(RoseBottomGradient)
            ) {
                Text("Dismiss", color = DarkRed)
            }
        }
    )
}

@Preview
@Composable
private fun AlertDialogLogoutPreview() {
    AlertDialogLogout(onConfirm = {}, onDismiss = {})
}