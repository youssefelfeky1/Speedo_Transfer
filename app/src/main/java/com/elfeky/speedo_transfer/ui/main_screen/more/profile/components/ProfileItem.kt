package com.elfeky.speedo_transfer.ui.main_screen.more.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.GreyText
import com.elfeky.speedo_transfer.ui.theme.RedP50

@Composable
fun ProfileItem(
    modifier: Modifier = Modifier,
    primaryText: String,
    secondaryText: String,
    logo: Int,
    contentDescription: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth().height(70.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(RedP50)

        ) {
            Image(
                painter = painterResource(id = logo),
                contentDescription = contentDescription,
                modifier = modifier.align(Alignment.Center)
            )
        }
        Column(modifier = modifier.padding(start = 16.dp)) {
            Text(
                text = primaryText,
                fontSize = 16.sp,
                color = GrayG900,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = modifier.padding(top =4.dp))
            Text(text = secondaryText, fontSize = 16.sp, color = GreyText)

        }
        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.right_arrow),
            contentDescription = "next",
            modifier = modifier
                .size(20.dp)


        )
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProfileItemPreview() {
    ProfileItem(
        primaryText = "Personal Informtaion",
        secondaryText = "Your information",
        logo = R.drawable.user_1,
        contentDescription = ""
    )
}