package com.elfeky.speedo_transfer.ui.main_screen.more.favourites.fav_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.DangerD300
import com.elfeky.speedo_transfer.ui.theme.GrayG100
import com.elfeky.speedo_transfer.ui.theme.GrayG200
import com.elfeky.speedo_transfer.ui.theme.GrayG40
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.RedP50

@Composable
fun itemCard(accountName: String, accountDescripton: String, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(RedP50)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(88.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Image(
                painter = painterResource(id = R.drawable.imagecard),
                contentDescription = "picCard",
                modifier = modifier
                    .padding(start = 16.dp)
                    .size(56.dp)
                    .clip(shape = CircleShape)
                    .background(color = GrayG40)
            )

            Column(
                modifier = modifier
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = accountName,
                    fontSize = 16.sp,
                    color = GrayG900,
                    fontWeight = FontWeight.Medium,
                    modifier = modifier
                        .padding(bottom = 8.dp)

                )
                Text(
                    text = accountDescripton,
                    color = GrayG100,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                )
            }

            Spacer(modifier = modifier.weight(1f))

            Icon(
                painter = painterResource(id = R.drawable.edit_1),
                contentDescription = "logout",
                modifier = Modifier.size(24.dp).clickable {


                },
                tint = GrayG200
            )
            Spacer(modifier = Modifier.width(12.dp))
            Icon(
                painter = painterResource(id = R.drawable.delete_1),
                contentDescription = "logout",
                modifier = Modifier.size(24.dp).clickable {

                },
                tint = DangerD300
            )
            Spacer(modifier = Modifier.width(16.dp))


        }


    }
    Spacer(modifier = Modifier.height(16.dp))
}
