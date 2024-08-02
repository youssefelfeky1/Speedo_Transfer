package com.elfeky.speedo_transfer.ui.main_screen.home.components

import androidx.compose.foundation.Image
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.elfeky.speedo_transfer.ui.theme.GrayG200
import com.elfeky.speedo_transfer.ui.theme.GrayG40
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.ui.theme.RedP50

@Composable
fun RecentTransactionsSection(onClickViewAll: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Recent transactions",
                color = GrayG900,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
            Text(
                text = "View all",
                color = GrayG200,
                fontSize = 16.sp,
                modifier = Modifier
                    .clickable { onClickViewAll() }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        RecentTransactionSectionItem()
        HorizontalDivider()
        RecentTransactionSectionItem()
        HorizontalDivider()
        RecentTransactionSectionItem()

    }
}


@Composable
fun RecentTransactionSectionItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(74.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color.White)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.visa),
                contentDescription = "Visa",
                modifier = modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(RedP50)
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {

            }
        }

        Text(
            text = "$1000",
            color = RedP300,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

    }
}


@Preview(showBackground = true)
@Composable
private fun RecentTransactionsSectionPreview() {
    RecentTransactionsSection(onClickViewAll = {})
}