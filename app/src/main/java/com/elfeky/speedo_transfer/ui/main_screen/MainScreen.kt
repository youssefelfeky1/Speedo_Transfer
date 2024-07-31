package com.elfeky.speedo_transfer.ui.main_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elfeky.speedo_transfer.navigation.MainNavigation



@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    MainNavigation()
}



@Preview(showBackground = true)
@Composable
private fun MainNScreenPreview() {
    MainScreen()
}