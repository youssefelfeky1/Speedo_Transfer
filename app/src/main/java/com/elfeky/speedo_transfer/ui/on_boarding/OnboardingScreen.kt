package com.elfeky.speedo_transfer.ui.on_boarding


import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.elfeky.speedo_transfer.R


@Composable
fun AmountScreen(navController: NavController,hostNavController: NavController) {
    OnboardingScreen(
        navController = navController,
        hostNavController = hostNavController,
        title = "Amount",
        description = "Send money fast with simple steps. Create account, Confirmation, Payment. Simple.",
        imageResId = R.drawable.amont,
        onNextClick = { navController.navigate(OnboardingScreenRoutes.Confirmation.route) },
        totalScreens = 3,
        currentIndex = 0
    )
}

@Composable
fun ConfirmationScreen(navController: NavController,hostNavController: NavController) {
    OnboardingScreen(
        navController = navController,
        hostNavController = hostNavController,
        title = "Confirmation",
        description = "Transfer funds instantly to friends and family worldwide, strong shield protecting a money.",
        imageResId = R.drawable.confirmation,
        onNextClick = { navController.navigate(OnboardingScreenRoutes.Payment.route) },
        totalScreens = 3,
        currentIndex = 1
    )
}

@Composable
fun PaymentScreen(navController: NavController,hostNavController: NavController) {
    OnboardingScreen(
        navController = navController,
        hostNavController = hostNavController,
        title = "Payment",
        description = "Enjoy peace of mind with our secure platform. Transfer funds instantly to friends.",
        imageResId = R.drawable.payment,
        onNextClick = { hostNavController.navigate("MainScreen")},
        totalScreens = 3,
        currentIndex = 2
    )
}
