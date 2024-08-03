package com.elfeky.speedo_transfer.ui.main_screen.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.ui.main_screen.transactions.components.TransactionItem
import com.elfeky.speedo_transfer.ui.main_screen.transfer.MainTopAppBar
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient
import com.elfeky.speedo_transfer.ui.theme.YellowTopGradient
import com.elfeky.speedo_transfer.util.Constants.TRANSACTION_DETAIL

@Composable
fun TransactionsScreen(navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(YellowTopGradient, RoseBottomGradient)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            containerColor = Color.Transparent,
            topBar = {
                MainTopAppBar(title = "Transactions") {
                    navController.popBackStack()
                }
            }
            ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Your Last Transactions",
                    color = GrayG900,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item{
                        TransactionItem(onItemClick = { navController.navigate(TRANSACTION_DETAIL) })
                    }
                }
            }


        }
    }
}


@Preview(showBackground = true)
@Composable
private fun TransactionsScreenPreview() {
    TransactionsScreen(navController = rememberNavController())
}