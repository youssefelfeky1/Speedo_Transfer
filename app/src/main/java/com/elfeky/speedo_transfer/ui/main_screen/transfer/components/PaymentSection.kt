package com.elfeky.speedo_transfer.ui.main_screen.transfer.components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
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
import com.elfeky.speedo_transfer.ui.main_screen.sendNotification
import com.elfeky.speedo_transfer.ui.main_screen.transfer.TransferViewModel
import com.elfeky.speedo_transfer.ui.theme.GrayG0
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.util.Constants.HOME

@Composable
fun PaymentSection(
    amount: MutableState<String>,
    recipientName: MutableState<String>,
    recipientAccount: MutableState<String>,
    afterTax: Float = 1f,
    stageNumber: MutableState<Int>,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: TransferViewModel = viewModel()
) {
    val context = LocalContext.current

    sendNotification(
        context,
        "Successful Transaction",
        "You have sent ${amount.value} £ to ${recipientName.value}"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.check_mark),
            contentDescription = "check mark",
            modifier = Modifier
                .size(112.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Your transfer was successful",
            color = GrayG900,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                UserInformationItem(name = "Youssef ELfeky", account = "123954535", isSender = true)
                Spacer(modifier = Modifier.height(12.dp))
                UserInformationItem(
                    name = recipientName.value,
                    account = recipientAccount.value,
                    isSender = false
                )
            }
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.check),
                contentDescription = "Transfer",
                modifier = Modifier.size(44.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Transfer amount",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = GrayG900,
            )
            Text(
                text = "${amount.value.toInt() * afterTax} £",
                fontSize = 16.sp,
                color = GrayG900,
            )

        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                stageNumber.value = 1
                amount.value = ""
                recipientName.value = ""
                recipientAccount.value = ""
                navController.navigate(HOME)
            },
            colors = ButtonDefaults.buttonColors(containerColor = RedP300),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text(
                text = "Back to Home",
                color = GrayG0,
                fontSize = 16.sp,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = {
                viewModel.upsertRecipient(
                    Recipient(
                        recipientName = recipientName.value,
                        recipientAccount = recipientAccount.value
                    )
                )
                Toast.makeText(context, "Added Successfully to Favorites", Toast.LENGTH_LONG).show()
            },
            border = BorderStroke(1.5.dp, RedP300),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text(
                text = "Add to Favourite  ",
                color = RedP300,
                fontSize = 16.sp,
            )
        }

    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
private fun PaymentSectionPreview() {
    PaymentSection(
        amount = mutableStateOf("1000"),
        recipientName = mutableStateOf("Philip Lackner"),
        recipientAccount = mutableStateOf("234234545453"),
        stageNumber = mutableStateOf(2),
        navController = rememberNavController()
    )
}