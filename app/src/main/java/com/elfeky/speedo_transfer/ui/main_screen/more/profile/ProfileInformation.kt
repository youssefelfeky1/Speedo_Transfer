package com.elfeky.speedo_transfer.ui.main_screen.more.profile

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
import com.elfeky.speedo_transfer.ui.main_screen.more.profile.components.ProfileInfoItem
import com.elfeky.speedo_transfer.ui.main_screen.more.profile.components.TopAppBarSection
import com.elfeky.speedo_transfer.ui.main_screen.transfer.MainTopAppBar
import com.elfeky.speedo_transfer.ui.theme.YellowTopGradient

@Composable
fun ProfileInformation(modifier: Modifier = Modifier , navController: NavController) {

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
        MainTopAppBar(title = "Profile information"){
            navController.popBackStack()

        }
        Spacer(modifier = modifier.padding(bottom = 28.dp))
        ProfileInfoItem(primaryName = "Full Name ", secondaryName = "Youssef Shawky")
        ProfileInfoItem(primaryName = "Email", secondaryName = "youssefshawky2002@gmail.com")
        ProfileInfoItem(primaryName = "Date Of Birth", secondaryName = "5/5/2002")
        ProfileInfoItem(primaryName = "Date Of Birth", secondaryName = "5/5/2002")
        ProfileInfoItem(primaryName = "Country", secondaryName = "Egypt")
        ProfileInfoItem(primaryName = "Bacnk Account", secondaryName = "1234xxxx")

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProfileInformationPreview() {
    ProfileInformation(navController = rememberNavController())

}