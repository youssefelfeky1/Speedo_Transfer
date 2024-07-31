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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.DarkRed

@Composable
fun WelcomeSection(
    fullName: String, navController: NavController,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        WelcomeProfile(fullName = fullName)
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.notifications_1),
            contentDescription = "Notification",
            modifier = Modifier
                .size(32.dp)
//                .clickable { navController.navigate("notifications") }
        )

    }
}


@Composable
fun ProfileSymbol(fullName: String, modifier: Modifier = Modifier) {
    val firstLetter = fullName.split(" ")[0][0]
    val lastLetter = fullName.split(" ")[1][0]

    Box(
        modifier
            .clip(CircleShape)
            .background(Color(0xFFE3E2E2)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$firstLetter$lastLetter",
            color = Color(0xFF898886),
            modifier = Modifier.padding(9.dp)
        )
    }
}

@Composable
fun WelcomeProfile(fullName: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileSymbol(fullName = fullName)
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = "Welcome back, ",
                color = DarkRed,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = fullName,
                color = Color(0xFF24221E),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}

