package com.elfeky.speedo_transfer.ui.main_screen.more.favourites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.ui.main_screen.more.favourites.fav_components.itemCard
import com.elfeky.speedo_transfer.ui.main_screen.transfer.TransferTopAppBar
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.YellowTopGradient

@Composable
fun FavouriteScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        YellowTopGradient,
                        Color(0xFFFFEAEE)
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        TransferTopAppBar(title = "Favourite") {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Your favourite list",
            style = MaterialTheme.typography.titleMedium,
            color = GrayG900,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(32.dp))

        val itemsList = 3

        LazyColumn {
            items(itemsList) { item ->
                itemCard(accountName = "Amr Nasser", accountDescripton = "Account xxxx7890")
            }
        }

    }

}


@Preview(showBackground = true)
@Composable
private fun FavouriteScreenPreview() {
    FavouriteScreen(navController = rememberNavController())
}
