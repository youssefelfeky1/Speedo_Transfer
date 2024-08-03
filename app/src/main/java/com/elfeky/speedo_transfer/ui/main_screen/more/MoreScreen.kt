package com.elfeky.speedo_transfer.ui.main_screen.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.ui.main_screen.more.components.AlertDialogLogout
import com.elfeky.speedo_transfer.ui.main_screen.more.components.HelpBS
import com.elfeky.speedo_transfer.ui.main_screen.more.components.LogoutSection
import com.elfeky.speedo_transfer.ui.main_screen.more.components.MoreNavigationSection
import com.elfeky.speedo_transfer.ui.main_screen.transfer.MainTopAppBar
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient
import com.elfeky.speedo_transfer.ui.theme.YellowTopGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(navController: NavController) {
    val showBottomSheet = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        YellowTopGradient,
                        RoseBottomGradient
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

        MoreNavigationSection(navController = navController , onHelpClick = { showBottomSheet.value = true }  )

        // Logout AlertDialog
        var showDialog by remember { mutableStateOf(false) }
        LogoutSection(onClick = { showDialog = true })

        if (showDialog) {
            AlertDialogLogout(
                onDismiss = { showDialog = false },
                onConfirm = {
                    showDialog = false
                    // navController.navigate("SignIn")
                }
            )
        }


        // help bottomSheet
        val sheetState = rememberModalBottomSheetState()

        if (showBottomSheet.value) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet.value = false
                },
                sheetState = sheetState
            ) {
                // Sheet content

                HelpBS()

            }

        }


    }

}


@Preview(showBackground = true)
@Composable
private fun MoreScreenPreview() {
    MoreScreen(navController = rememberNavController())
}

