package com.elfeky.speedo_transfer.ui.on_boarding


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.theme.DarkRed

@Composable
fun OnboardingScreen(
    navController: NavController,
    title: String,
    description: String,
    @DrawableRes imageResId: Int,
    onNextClick: () -> Unit,
    totalScreens: Int,
    currentIndex: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color(0xFFFFEAEE)
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Skip",
            fontSize = 16.sp,
            modifier = Modifier
                .clickable {}
                .padding(top = 14.dp)
                .align(alignment = Alignment.End),
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(18.dp))
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier.size(350.dp)
        )
        DotIndicator(
            totalDots = totalScreens,
            currentIndex = currentIndex
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            onClick = { onNextClick() },
            colors = ButtonDefaults.buttonColors(containerColor = DarkRed),
            shape = RoundedCornerShape(size = 8.dp)
        ) {
            Text(
                text = "Next",
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun OnboardingScreenPreview() {
    val navController = rememberNavController()

    OnboardingScreen(
        navController = navController,
        title = "Amount",
        description = "Send money fast with simple steps. Create account, Confirmation, Payment. Simple.",
        imageResId = R.drawable.amont,
        onNextClick = { },
        totalScreens = 3,
        currentIndex = 0
    )
}

