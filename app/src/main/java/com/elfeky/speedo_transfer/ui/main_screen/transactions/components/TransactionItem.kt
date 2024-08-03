package com.elfeky.speedo_transfer.ui.main_screen.transactions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
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
import com.elfeky.speedo_transfer.ui.theme.GrayG700
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.ui.theme.RedP50

@Composable
fun TransactionItem(onItemClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable { onItemClick() }
            .background(GrayG0)
            .padding(horizontal = 8.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.card2_1),
                contentDescription = "Card",
                modifier = Modifier
                    .align(Alignment.Top)
                    .clip(RoundedCornerShape(8.dp))
                    .background(RedP50)
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "Philip Lackner",
                    color = GrayG900,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Visa . Mater Card . 1234",
                    color = GrayG700,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Today 11:00 - Received",
                    color = GrayG100,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$1000",
                    color = RedP300,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Column {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.drop_down_1),
                contentDescription = "Details",
                modifier = Modifier
                    .scale(scaleX = -1f, scaleY = 1f)
                    .size(24.dp)
                    .align(Alignment.End)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Successful",
                color = Color(0xFF118A30),
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFEAF3EC))
                    .padding(horizontal = 10.dp, vertical = 3.dp)

            )

        }

    }
}

@Preview
@Composable
private fun TransactionItemPreview() {
    TransactionItem(onItemClick = {})
}