package com.elfeky.speedo_transfer.ui.main_screen.transfer.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.GrayG0
import com.elfeky.speedo_transfer.ui.theme.GrayG100
import com.elfeky.speedo_transfer.ui.theme.GrayG40
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.ui.theme.RedP50

@Composable
fun ConfirmationSection(
    amount: MutableState<String>,
    recipientName: MutableState<String>,
    recipientAccount: MutableState<String>,
    afterTax: Float = 1f,
    stageNumber: MutableState<Int>,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = amount.value + " £",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF24221E),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Transfer amount",
            fontSize = 16.sp,
            color = Color(0xFF565552),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Total amount",
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
        HorizontalDivider()
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
                imageVector = ImageVector.vectorResource(id = R.drawable.group_18316),
                contentDescription = "Transfer",
                modifier = Modifier.size(44.dp)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { stageNumber.value += 1 },
            colors = ButtonDefaults.buttonColors(containerColor = RedP300),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text(
                text = "Confirm",
                color = GrayG0,
                fontSize = 16.sp,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = { stageNumber.value -= 1 },
            border = BorderStroke(1.5.dp, RedP300),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text(
                text = "Previous ",
                color = RedP300,
                fontSize = 16.sp,
            )
        }

    }
}


@Composable
fun UserInformationItem(
    modifier: Modifier = Modifier,
    name: String,
    account: String,
    isSender: Boolean
) {
    val accountLength = account.length
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(RedP50)
            .padding(horizontal = 16.dp)
            .padding(16.dp)
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
                text = if (isSender) "From" else "To",
                color = RedP300,
                fontSize = 16.sp,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = name,
                color = GrayG900,
                fontSize = 16.sp,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Account xxxx${account[accountLength - 4]}" +
                        "${account[accountLength - 3]}" +
                        "${account[accountLength - 2]}" +
                        "${account[accountLength - 1]}",
                color = GrayG100,
                fontSize = 16.sp,
            )
        }

    }
}


@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun ConfirmationSectionPreview(
    modifier: Modifier = Modifier
) {
    ConfirmationSection(
        amount = mutableStateOf("1000"),
        recipientName = mutableStateOf("Philip Lackner"),
        recipientAccount = mutableStateOf("12345647634"),
        stageNumber = mutableStateOf(1)
    )
}