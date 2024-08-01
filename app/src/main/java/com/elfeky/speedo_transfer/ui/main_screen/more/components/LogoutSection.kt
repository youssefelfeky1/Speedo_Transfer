package com.elfeky.speedo_transfer.ui.main_screen.more.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.GrayG200

@Composable
fun LogoutSection(onClick:   () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.logout_1),
            contentDescription = "logout",
            modifier = Modifier.size(24.dp),
            tint = GrayG200
        )
        Text(
            text = "logout",
            style = MaterialTheme.typography.labelSmall,
            color = GrayG200,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 8.dp)
        )

    }
}