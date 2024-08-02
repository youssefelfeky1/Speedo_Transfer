package com.elfeky.speedo_transfer.ui.main_screen.home.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.ui.theme.DarkRed

@SuppressLint("DefaultLocale")
@Composable
fun CurrentBalanceSection(currentBalance: Float, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkRed)
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 25.dp, horizontal = 13.dp)
        ) {
            Text(
                text = "Current Balance",
                color = Color.White,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$${String.format("%,.2f", currentBalance)}",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Preview
@Composable
private fun CurrentBalanceSectionPreview() {
    CurrentBalanceSection(currentBalance = 2234234.2f)
}