package com.elfeky.speedo_transfer.ui.main_screen.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.main_screen.transfer.MainTopAppBar
import com.elfeky.speedo_transfer.ui.main_screen.transfer.components.UserInformationItem
import com.elfeky.speedo_transfer.ui.theme.GrayG100
import com.elfeky.speedo_transfer.ui.theme.GrayG700
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.ui.theme.RedP50
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient
import com.elfeky.speedo_transfer.ui.theme.YellowTopGradient

@Composable
fun TransactionDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
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
                MainTopAppBar(title = "Successful Transactions") {
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
                Spacer(modifier = Modifier.height(32.dp))
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.chcek),
                    contentDescription = "Done",
                    modifier = Modifier.size(width = 124.dp, height = 120.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(color = GrayG900)) {
                            append("1000")
                        }
                        withStyle(SpanStyle(color = RedP300)) {
                            append(" L.E")
                        }
                    },
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Transfer amount",
                    fontSize = 16.sp,
                    color = GrayG700
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Send money",
                    fontSize = 14.sp,
                    color = RedP300
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(contentAlignment = Alignment.Center) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        UserInformationItem(
                            name = "Youssef ELfeky",
                            account = "123954535",
                            isSender = true
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        UserInformationItem(
                            name = "Philip Lackner",
                            account = "2135986564",
                            isSender = false
                        )
                    }
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.check),
                        contentDescription = "Transfer",
                        modifier = Modifier.size(44.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                InformationItem(title = "Reference", value = "123456789876")
                HorizontalDivider()
                InformationItem(title = "Date", value = "20 Jul 2024 7:50 PM")

            }


        }
    }
}


@Composable
fun InformationItem(title: String, value: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(RedP50)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            color = GrayG700
        )
        Text(
            text = value,
            fontSize = 14.sp,
            color = GrayG100
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun TransactionDetailPreview() {
    TransactionDetailScreen(navController = rememberNavController())
}