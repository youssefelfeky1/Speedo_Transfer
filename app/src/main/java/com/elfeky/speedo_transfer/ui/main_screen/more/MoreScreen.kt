package com.elfeky.speedo_transfer.ui.main_screen.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.ui.main_screen.more.components.AlertDialogLogout
import com.elfeky.speedo_transfer.ui.main_screen.more.components.LogoutSection
import com.elfeky.speedo_transfer.ui.main_screen.more.components.MoreNavigationSection
import com.elfeky.speedo_transfer.ui.main_screen.transfer.MainTopAppBar
import com.elfeky.speedo_transfer.ui.theme.YellowTopGradient

@Composable
fun MoreScreen(navController: NavController, modifier: Modifier = Modifier) {
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
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        MainTopAppBar(title = "More") {
            navController.popBackStack()
        }

        Spacer(modifier = Modifier.height(32.dp))

        MoreNavigationSection(navController)

        var showDialog by remember { mutableStateOf(false) }
        LogoutSection(onClick = {
            showDialog = true
        })

        if (showDialog) {
            AlertDialogLogout(
                onDismiss = { showDialog = false },
                onConfirm = {
                    showDialog = false
                    // navController.navigate("SignIn")
                }
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
private fun MoreScreenPreview() {
    MoreScreen(navController = rememberNavController())
}

