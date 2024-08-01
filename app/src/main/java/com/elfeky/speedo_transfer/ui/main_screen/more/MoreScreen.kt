package com.elfeky.speedo_transfer.ui.main_screen.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.ui.main_screen.more.components.LogoutSection
import com.elfeky.speedo_transfer.ui.main_screen.more.components.MoreNavigationSection
import com.elfeky.speedo_transfer.ui.main_screen.more.components.TopAppBarSection

@Composable
fun MoreScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color(0xFFFFEAEE)
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        TopAppBarSection("More")
        Spacer(modifier = Modifier.height(32.dp))
        MoreNavigationSection(navController)
        LogoutSection(onClick = {
            // dialog
        })
    }

}


@Preview(showBackground = true)
@Composable
private fun MoreScreenPreview() {
    MoreScreen(navController = rememberNavController())
}

