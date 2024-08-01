package com.elfeky.speedo_transfer.ui.main_screen.more.profile

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.main_screen.home.components.ProfileSymbol
import com.elfeky.speedo_transfer.ui.main_screen.more.profile.components.ProfileItem
import com.elfeky.speedo_transfer.ui.main_screen.more.profile.components.TopAppBarSection
import com.elfeky.speedo_transfer.ui.theme.BlackText
import com.elfeky.speedo_transfer.ui.theme.YellowTopGradient

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
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
            .padding(8.dp)
    ) {
        TopAppBarSection(text = "Profile")
        Spacer(modifier = modifier.padding(12.dp))

        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileSymbol(
                fullName = "Youssef Shawky",
                modifier = modifier.size(48.dp)
            )
            Text(text = "Youssef Shawky",
                fontSize = 20.sp,
                color = BlackText,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(start = 12.dp)

            )
        }
        Spacer(modifier = modifier.padding(12.dp))




        ProfileItem(
            primaryText = "Personal information",
            secondaryText = "Your information",
            logo = R.drawable.user_1,
            contentDescription = "user"
        )
        HorizontalDivider(
            thickness = 1.dp,
            modifier = modifier.padding(vertical = 4.dp)
        )
        ProfileItem(
            primaryText = "Setting",
            secondaryText = "Change your settings",
            logo = R.drawable.setting_1,
            contentDescription = "settings"
        )
        HorizontalDivider(
            thickness = 1.dp,
            modifier = modifier.padding(vertical = 4.dp)
        )
        ProfileItem(
            primaryText = "Payment history",
            secondaryText = "view your transactions",
            logo = R.drawable.history_1,
            contentDescription = "payment"
        )
        HorizontalDivider(
            thickness = 1.dp,
            modifier = modifier.padding(vertical = 4.dp)
        )
        ProfileItem(
            primaryText = "My Favourite list",
            secondaryText = "view your favourites",
            logo = R.drawable.favorite_1,
            contentDescription = "favourite"
        )


    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()

}