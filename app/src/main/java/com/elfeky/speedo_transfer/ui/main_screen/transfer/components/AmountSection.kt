package com.elfeky.speedo_transfer.ui.main_screen.transfer.components

import android.annotation.SuppressLint
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.data.model.Recipient
import com.elfeky.speedo_transfer.ui.theme.GrayG0
import com.elfeky.speedo_transfer.ui.theme.GrayG10
import com.elfeky.speedo_transfer.ui.theme.GrayG100
import com.elfeky.speedo_transfer.ui.theme.GrayG40
import com.elfeky.speedo_transfer.ui.theme.GrayG70
import com.elfeky.speedo_transfer.ui.theme.GrayG700
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.ui.theme.RedP50
import com.elfeky.speedo_transfer.ui.theme.RedP75

@Composable
fun AmountSection(
    modifier: Modifier = Modifier,
    amount: MutableState<String>,
    recipientName: MutableState<String>,
    recipientAccount: MutableState<String>,
    showBottomSheet: MutableState<Boolean>,
    onContinue: () -> Unit,
    youSend: Float = 1f,
    recipientGets: Float = 48.4220f,
) {
    Column {
        Text(
            text = "How much are you sending?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = GrayG900
        )
        Spacer(modifier = Modifier.height(24.dp))

//        Text(
//            text = "Choose Currency",
//            fontSize = 16.sp,
//            color = GrayG700
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))

//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .clip(RoundedCornerShape(8.dp))
//                .background(Color.White)
//                .padding(horizontal = 8.dp, vertical = 16.dp)
//
//        ) {

        OutlinedTextField(
            value = amount.value,
            onValueChange = { amount.value = it },
            maxLines = 1,
            label = { Text(text = "Enter Amount") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = RedP300,
                unfocusedBorderColor = GrayG70,
                unfocusedContainerColor = GrayG10,
                focusedContainerColor = GrayG10,
                focusedLabelColor = RedP300
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
        )
//                Text(
//                    text = "$youSend USD = $recipientGets EGP",
//                    fontSize = 16.sp,
//                    color = GrayG700
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                Text(
//                    text = "Rate guaranteed (2h)",
//                    fontSize = 14.sp,
//                    color = GrayG100
//                )
//                Spacer(modifier = Modifier.height(16.dp))

//        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Recipient Information",
                color = GrayG700,
                fontSize = 16.sp
            )
            Favourite {
                showBottomSheet.value = true
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Recipient Name",
            fontSize = 16.sp,
            color = GrayG700
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = recipientName.value,
            onValueChange = {
                recipientName.value = it
            },
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
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Recipient Account",
            fontSize = 16.sp,
            color = GrayG700
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = recipientAccount.value,
            onValueChange = {
                recipientAccount.value = it
            },
            label = { Text(text = "Enter Percipient Account Number") },
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
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onContinue() },
            colors = ButtonDefaults.buttonColors(containerColor = RedP300),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(6.dp),
            enabled = (amount.value.isNotBlank() && recipientName.value.isNotBlank() && recipientAccount.value.isNotBlank())
        ) {
            Text(
                text = "Continue",
                color = GrayG0,
                fontSize = 16.sp,
            )
        }

    }
}


@Composable
fun Favourite(modifier: Modifier = Modifier, onFavouriteClick: () -> Unit) {
    Row(
        modifier = Modifier.clickable { onFavouriteClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.favorite_1),
            contentDescription = "Favourite",
            tint = RedP300,
            modifier = Modifier.padding(end = 4.dp)
        )
        Text(
            text = "Favourite",
            fontSize = 14.sp,
            color = RedP300,
            modifier = Modifier.padding(end = 4.dp)
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.drop_down_1),
            contentDescription = "Go to favourite",
            modifier = Modifier
                .size(16.dp)
                .scale(scaleX = -1f, scaleY = 1f),
            tint = RedP300
        )


    }
}

@Composable
fun FavouriteBottomSheet(
    favouriteRecipients: List<Recipient>,
    onItemClick: (Recipient) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        favouriteRecipients.forEach { recipient ->
            FavouriteListItem(recipient = recipient, onItemClick = { onItemClick(it) })
            Spacer(modifier = Modifier.height(16.dp))
        }
    }


}


@Composable
fun FavouriteListItem(
    recipient: Recipient,
    onItemClick: (Recipient) -> Unit,
    modifier: Modifier = Modifier
) {
    val accountLength = recipient.recipientAccount.length
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(RedP50)
            .padding(16.dp)
            .clickable { onItemClick(recipient) }
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.bank_1),
            contentDescription = "Bank",
            modifier = Modifier
                .clip(CircleShape)
                .background(GrayG40)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = recipient.recipientName,
                color = GrayG900,
                fontSize = 16.sp,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Account xxxx${recipient.recipientAccount[accountLength - 4]}" +
                        "${recipient.recipientAccount[accountLength - 3]}" +
                        "${recipient.recipientAccount[accountLength - 2]}" +
                        "${recipient.recipientAccount[accountLength - 1]}",
                color = GrayG100,
                fontSize = 16.sp,
            )
        }

    }
}


@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
private fun AmountSectionPreview() {
    AmountSection(
        recipientAccount = mutableStateOf(""),
        recipientName = mutableStateOf(""),
        onContinue = {},
        showBottomSheet = mutableStateOf(false),
        amount = mutableStateOf("")
    )
}