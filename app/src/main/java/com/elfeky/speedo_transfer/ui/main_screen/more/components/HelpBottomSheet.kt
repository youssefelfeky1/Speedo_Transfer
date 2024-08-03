package com.elfeky.speedo_transfer.ui.main_screen.more.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.main_screen.more.MoreScreen
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.ui.theme.RedP50
import com.elfeky.speedo_transfer.util.Constants.MORE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpBottomSheet(navController: NavController) {

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(true) }
    Scaffold { contentPadding ->
        // Screen content
        MoreScreen(
            navController = navController,
        )

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                    navController.navigate(MORE)
                },
                sheetState = sheetState
            ) {
                // Sheet content

                Row(
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                       ContactOptions()

                }

            }

        }
    }
}


@Composable
fun ContactOptions() {
    val context = LocalContext.current

    ContactOption(
        iconRes = R.drawable.email_1,
        title = "Send Email",
        subtitle = "",
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"))
            context.startActivity(intent)
        }
    )
    Spacer(modifier = Modifier.width(32.dp))
    ContactOption(
        iconRes = R.drawable.call_1,
        title = "Call Us",
        subtitle = "000000",
        onClick = {
            val intent = Intent(Intent.ACTION_DIAL)
            context.startActivity(intent)
        }
    )


}

@Composable
fun ContactOption(iconRes: Int, title: String, subtitle: String, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .width(150.dp)
            .clickable {
                onClick()
            }

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .width(140.dp)
                .height(140.dp)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .size(55.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(color = RedP50),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = null,
                    tint = RedP300,
                    modifier = Modifier
                        .size(24.dp)


                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = title,
                color = Color(0xFF333333),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            if (subtitle.isNotEmpty()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = subtitle,
                    color = RedP300,
                    fontSize = 14.sp
                )
            }
        }
    }

}
