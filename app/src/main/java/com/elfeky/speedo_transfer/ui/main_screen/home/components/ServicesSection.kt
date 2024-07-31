package com.elfeky.speedo_transfer.ui.main_screen.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.data.model.Service

@Composable
fun ServicesSection(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        Text(
            text = "Services",
            color = Color(0xFF3C3A37),
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Services(
            services = listOf(
                Service(icon = R.drawable.transfer_1, "Transfer"),
                Service(icon = R.drawable.history_1, "Transactions"),
                Service(icon = R.drawable.cards_1, "Cards"),
                Service(icon = R.drawable.account_1, "Account"),

                )
        )
    }

}


@Composable
fun Services(services: List<Service>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        services.forEach { service ->
            ServiceItem(service = service)
        }
    }
}

@Composable
fun ServiceItem(service: Service, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFFFBFBFB))
                .padding(16.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = service.icon),
                contentDescription = service.title,
                tint = Color(0xFF9F7815),
                )
        }
        Text(
            text = service.title,
            fontSize = 14.sp,
            color = Color(0xFF3C3A37),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ServicesSectionPreview() {
    ServicesSection()
}