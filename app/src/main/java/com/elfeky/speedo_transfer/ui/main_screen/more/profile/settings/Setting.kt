package com.elfeky.speedo_transfer.ui.main_screen.more.profile.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.main_screen.more.profile.components.ProfileItem
import com.elfeky.speedo_transfer.ui.main_screen.more.profile.components.TopAppBarSection
import com.elfeky.speedo_transfer.ui.main_screen.transfer.MainTopAppBar
import com.elfeky.speedo_transfer.ui.theme.YellowTopGradient

@Composable
fun Setting(modifier: Modifier = Modifier, navController: NavController) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        YellowTopGradient,
                        Color(0xFFFFEAEE)
                    )
                )
            )
            .padding(16.dp)
    ) {
        MainTopAppBar(title = "Setting") {
            navController.popBackStack()
        }
        Spacer(modifier = modifier.padding(16.dp))
        ProfileItem(
            primaryText = "Change password",
            secondaryText = "Change password",
            logo = R.drawable.lock,
            contentDescription = "Change password",
            navController = navController
        )
        ProfileItem(
            primaryText = "Edit Profile",
            secondaryText = "Change your information",
            logo = R.drawable.edit_1,
            contentDescription = "Change your information",
            navController = navController
        )

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SettingPreview() {
    Setting(navController = rememberNavController())

}