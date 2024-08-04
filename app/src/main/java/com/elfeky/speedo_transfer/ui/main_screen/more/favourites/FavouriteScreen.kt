package com.elfeky.speedo_transfer.ui.main_screen.more.favourites

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.data.model.Recipient
import com.elfeky.speedo_transfer.ui.main_screen.transfer.MainTopAppBar
import com.elfeky.speedo_transfer.ui.theme.DangerD300
import com.elfeky.speedo_transfer.ui.theme.GrayG0
import com.elfeky.speedo_transfer.ui.theme.GrayG10
import com.elfeky.speedo_transfer.ui.theme.GrayG100
import com.elfeky.speedo_transfer.ui.theme.GrayG200
import com.elfeky.speedo_transfer.ui.theme.GrayG40
import com.elfeky.speedo_transfer.ui.theme.GrayG70
import com.elfeky.speedo_transfer.ui.theme.GrayG700
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.ui.theme.RedP50
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient
import com.elfeky.speedo_transfer.ui.theme.YellowTopGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: FavouriteViewModel = viewModel()
) {
    val favoriteRecipients by viewModel.selectAllRecipients().collectAsState(initial = emptyList())

    val showBottomSheet = remember {
        mutableStateOf(false)
    }

    val recipientName = remember {
        mutableStateOf("")
    }
    val recipientAccount = remember {
        mutableStateOf("")
    }
    val recipientId = remember {
        mutableStateOf(0)
    }


    val sheetState = rememberModalBottomSheetState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        YellowTopGradient,
                        RoseBottomGradient
                    )
                )
            )
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        MainTopAppBar(title = "Favourite") {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Your favourite list",
            style = MaterialTheme.typography.titleMedium,
            color = GrayG900,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(32.dp))


        FavouriteList(
            favouriteRecipients = favoriteRecipients,
            onEditItemClick = {
                showBottomSheet.value = true
                recipientId.value = it.id
                recipientName.value = it.recipientName
                recipientAccount.value = it.recipientAccount
            },
            onDeleteItemClick = { recipient ->
                viewModel.deleteRecipient(recipient)
            }
        )

        // edit bottom sheet

        if (showBottomSheet.value) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet.value = false
                },
                sheetState = sheetState
            ) {
                // Sheet content
                EditFavBtnSheet(
                    recipientId = recipientId,
                    recipientName = recipientName,
                    recipientAccount = recipientAccount,
                    onSave = { recipient ->
                        viewModel.upsertRecipientEdit(recipient)
                        showBottomSheet.value = false
                    }

                )


            }

        }


    }
}


@Composable
fun FavouriteList(
    favouriteRecipients: List<Recipient>,
    onEditItemClick: (Recipient) -> Unit,
    onDeleteItemClick: (Recipient) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        favouriteRecipients.forEach { recipient ->
            FavouriteListItemToEdit(
                recipient = recipient,
                onEditItemClick = { onEditItemClick(recipient) },
                onDeleteItemClick = { onDeleteItemClick(recipient) }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}

@Composable
fun FavouriteListItemToEdit(
    recipient: Recipient,
    onEditItemClick: (Recipient) -> Unit,
    onDeleteItemClick: (Recipient) -> Unit,
    modifier: Modifier = Modifier
) {
    val accountLength = recipient.recipientAccount.length

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(RedP50)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(88.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Image(
                painter = painterResource(id = R.drawable.imagecard),
                contentDescription = "picCard",
                modifier = modifier
                    .padding(start = 16.dp)
                    .size(56.dp)
                    .clip(shape = CircleShape)
                    .background(color = GrayG40)
            )

            Column(
                modifier = modifier
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = recipient.recipientName,
                    fontSize = 16.sp,
                    color = GrayG900,
                    fontWeight = FontWeight.Medium,
                    modifier = modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "Account xxxx${recipient.recipientAccount[accountLength - 4]}" +
                            "${recipient.recipientAccount[accountLength - 3]}" +
                            "${recipient.recipientAccount[accountLength - 2]}" +
                            "${recipient.recipientAccount[accountLength - 1]}",
                    color = GrayG100,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            Spacer(modifier = modifier.weight(1f))

            Icon(
                painter = painterResource(id = R.drawable.edit_1),
                contentDescription = "edit",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onEditItemClick(recipient)
                    },
                tint = GrayG200
            )
            Spacer(modifier = Modifier.width(12.dp))
            Icon(
                painter = painterResource(id = R.drawable.delete_1),
                contentDescription = "delete",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onDeleteItemClick(recipient)
                    },
                tint = DangerD300
            )
            Spacer(modifier = Modifier.width(16.dp))
        }

    }
    Spacer(modifier = Modifier.height(16.dp))

}

@Composable
fun EditFavBtnSheet(
    recipientId: MutableState<Int>,
    recipientName: MutableState<String>,
    recipientAccount: MutableState<String>,
    onSave: (Recipient) -> Unit,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val bottomSheetHeight = screenHeight / 2


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(bottomSheetHeight)
            .background(
                Color.White
            )
            .padding(horizontal = 16.dp, vertical = 44.dp)
    ) {
        Column(
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
                value = recipientAccount.value,
                onValueChange = { recipientAccount.value = it },
                label = { Text(text = "Enter Recipient Account") },
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
                value = recipientName.value,
                onValueChange = { recipientName.value = it },
                label = { Text(text = "Enter Recipient Name") },
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
                    onSave(
                        Recipient(
                            id = recipientId.value,
                            recipientName = recipientName.value,
                            recipientAccount = recipientAccount.value
                        )
                    )
                },
                colors = ButtonDefaults.buttonColors(containerColor = RedP300),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(6.dp),
                enabled = (recipientName.value.isNotBlank() && recipientAccount.value.isNotBlank())
            ) {
                Text(
                    text = "Save",
                    color = GrayG0,
                    fontSize = 16.sp,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun FavouriteScreenPreview() {
    FavouriteScreen(navController = rememberNavController())
}
