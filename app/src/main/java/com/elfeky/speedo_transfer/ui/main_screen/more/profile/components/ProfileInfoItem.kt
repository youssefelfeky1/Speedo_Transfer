package com.elfeky.speedo_transfer.ui.main_screen.more.profile.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.ui.theme.BlackText
import com.elfeky.speedo_transfer.ui.theme.GreyText

@Composable
fun ProfileInfoItem(modifier: Modifier = Modifier, primaryName: String, secondaryName: String) {

    Column(modifier = modifier.padding(4.dp)) {
        Text(
            text = primaryName,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = BlackText,
            modifier = modifier.padding(bottom = 8.dp)
        )
        Text(
            text = secondaryName,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = GreyText,
            modifier = modifier.padding(bottom = 4.dp)
        )
        HorizontalDivider(Modifier.padding(4.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProfileInfoItemPreview() {
    ProfileInfoItem(primaryName = "Full Name", secondaryName = "Youssef Shawky")

}