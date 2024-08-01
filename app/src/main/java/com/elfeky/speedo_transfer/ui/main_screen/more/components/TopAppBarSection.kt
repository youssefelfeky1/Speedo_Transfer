package com.elfeky.speedo_transfer.ui.main_screen.more.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.R

@Composable
fun TopAppBarSection(text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.drop_down_1),
            contentDescription = "arrow back",
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = text, fontSize = 20.sp,
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier
                .fillMaxWidth()
                .padding(end = 16.dp),

            textAlign = TextAlign.Center
        )
    }
}
