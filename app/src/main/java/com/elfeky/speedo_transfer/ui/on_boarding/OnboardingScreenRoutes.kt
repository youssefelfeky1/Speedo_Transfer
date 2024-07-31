package com.elfeky.speedo_transfer.ui.on_boarding



import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


sealed class OnboardingScreenRoutes(val route: String) {
    object Amount : OnboardingScreenRoutes("amount")
    object Confirmation : OnboardingScreenRoutes("confirmation")
    object Payment : OnboardingScreenRoutes("payment")

}
@Composable
fun OnboardingNavigation(navController: NavHostController,hostNavController: NavController) {
    NavHost(navController, startDestination = OnboardingScreenRoutes.Amount.route) {
        composable(OnboardingScreenRoutes.Amount.route) { AmountScreen(navController,hostNavController) }
        composable(OnboardingScreenRoutes.Confirmation.route) { ConfirmationScreen(navController,hostNavController) }
        composable(OnboardingScreenRoutes.Payment.route) { PaymentScreen(navController,hostNavController) }

    }
}