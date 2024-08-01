package com.elfeky.speedo_transfer.ui.main_screen.transfer.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.GrayG0
import com.elfeky.speedo_transfer.ui.theme.GrayG10
import com.elfeky.speedo_transfer.ui.theme.GrayG100
import com.elfeky.speedo_transfer.ui.theme.GrayG70
import com.elfeky.speedo_transfer.ui.theme.GrayG700
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.RedP300

@Composable
fun AmountSection(
    modifier: Modifier = Modifier,
    recipientName: MutableState<String>,
    recipientAccount: MutableState<String>,
    onContinue: () -> Unit,
    youSend:Float = 1f,
    recipientGets:Float = 48.4220f
) {
    Column {
        Text(
            text = "How much are you sending?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = GrayG900
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Choose Currency",
            fontSize = 16.sp,
            color = GrayG700
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .padding(horizontal = 8.dp, vertical = 16.dp)

        ) {
            Column {
                Text(
                    text = "$youSend USD = $recipientGets EGP",
                    fontSize = 16.sp,
                    color = GrayG700
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Rate guaranteed (2h)",
                    fontSize = 14.sp,
                    color = GrayG100
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
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
                /*TODO Open Favourite Recipients Bottom Sheet*/
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
            singleLine = true
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onContinue()},
            colors = ButtonDefaults.buttonColors(containerColor = RedP300),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(6.dp)
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




@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
private fun AmountSectionPreview() {
    AmountSection(recipientAccount = mutableStateOf(""), recipientName = mutableStateOf(""), onContinue = {})
}