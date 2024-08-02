package com.elfeky.speedo_transfer.ui.main_screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.ui.main_screen.home.components.CurrentBalanceSection
import com.elfeky.speedo_transfer.ui.main_screen.home.components.RecentTransactionsSection
import com.elfeky.speedo_transfer.ui.main_screen.home.components.ServicesSection
import com.elfeky.speedo_transfer.ui.main_screen.home.components.WelcomeSection
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient
import com.elfeky.speedo_transfer.ui.theme.YellowTopGradient

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(YellowTopGradient, RoseBottomGradient)
                )
            )
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(64.dp))
        WelcomeSection(fullName = "Youssef Elfeky", navController = navController)
        Spacer(modifier = Modifier.height(15.dp))
        CurrentBalanceSection(currentBalance = 2234234.20f,Modifier.clip(RoundedCornerShape(8.dp)))
        Spacer(modifier = Modifier.height(16.dp))
        ServicesSection()
        Spacer(modifier = Modifier.height(16.dp))
        RecentTransactionsSection()
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}