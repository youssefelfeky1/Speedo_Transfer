package com.elfeky.speedo_transfer.ui.main_screen.more.favourites.fav_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.main_screen.more.favourites.FavouriteScreen
import com.elfeky.speedo_transfer.ui.theme.GrayG0
import com.elfeky.speedo_transfer.ui.theme.GrayG10
import com.elfeky.speedo_transfer.ui.theme.GrayG70
import com.elfeky.speedo_transfer.ui.theme.GrayG700
import com.elfeky.speedo_transfer.ui.theme.RedP300
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditFavourite(
    navController: NavController,
    onSave: (String, String) -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(true) }
    Scaffold { _ ->
        // Screen content
        FavouriteScreen(
            navController = navController
        )

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                    navController.navigateUp()
                },
                sheetState = sheetState
            ) {
                // Sheet content
                EditFavBtnSheet(
                    scope, sheetState,
                    onDismiss = { showBottomSheet = false },
                    onSave = { recipientAccount, recipientName ->
                        onSave(recipientAccount, recipientName)
                        showBottomSheet = false
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EditFavBtnSheet(
    scope: CoroutineScope,
    sheetState: SheetState,
    onDismiss: () -> Unit,
    onSave: (String, String) -> Unit
) {
    var recipientAccount by remember {
        mutableStateOf("")
    }
    var recipientName by remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White
            )
            .padding(horizontal = 16.dp, vertical = 44.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.edit_1),
                contentDescription = "edit",
                tint = RedP300
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Edit", fontSize = 20.sp, color = GrayG700)
        }
        Spacer(modifier = Modifier.height(28.dp))
        Text(
            text = "Recipient Account",
            fontSize = 16.sp,
            color = GrayG700,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = recipientAccount,
            onValueChange = { recipientAccount = it },
            label = { Text(text = "Enter Cardholder Account") },
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
            text = "Recipient Name",
            fontSize = 16.sp,
            color = GrayG700,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = recipientName,
            onValueChange = { recipientName = it },
            label = { Text(text = "Enter Cardholder Name") },
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
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                onSave(recipientAccount, recipientName)
            },
            colors = ButtonDefaults.buttonColors(containerColor = RedP300),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(6.dp),
            enabled = (recipientName.isNotBlank() && recipientAccount.isNotBlank())
        ) {
            Text(
                text = "Save",
                color = GrayG0,
                fontSize = 16.sp,
            )
        }
        Spacer(modifier = Modifier.height(36.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun EditFavouritePreview() {
    EditFavourite(rememberNavController(), onSave = { _, _ -> })
}
