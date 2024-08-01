package com.elfeky.speedo_transfer.ui.main_screen.more.components

import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.GrayG200
import com.elfeky.speedo_transfer.ui.theme.GrayG40

@Composable
fun MoreNavigationSection(navController: NavController) {
    val context = LocalContext.current
    IconAndTextInMoreComponent(R.drawable.website_1, "Transfer From Website", onClick = {

        val webIntent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://www.banquemisr.com/")
        }
        context.startActivity(webIntent)
    })
    HorizontalDivider(color = GrayG40)
    IconAndTextInMoreComponent(R.drawable.favorite_1, "Favourites", onClick = {
        navController.navigate("Favourites")
    })
    HorizontalDivider(color = GrayG40)
    IconAndTextInMoreComponent(R.drawable.user, "Profile", onClick = {
       navController.navigate("Profile")
    })
    HorizontalDivider(color = GrayG40)
    IconAndTextInMoreComponent(R.drawable.support_1, "Help", onClick = {
        //  bottom sheet
    })
    HorizontalDivider(color = GrayG40)
}

@Composable
fun IconAndTextInMoreComponent(@DrawableRes icon: Int, text: String,  onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "website",
            modifier = Modifier.size(20.dp),
            tint = GrayG200
        )
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            color = GrayG200,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.chevron),
            contentDescription = "website",
            tint = GrayG200,
            modifier = Modifier
                .clickable { onClick() },
        )
    }
}