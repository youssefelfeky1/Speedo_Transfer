package com.elfeky.speedo_transfer.ui.on_boarding



import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


sealed class OnboardingScreenRoutes(val route: String) {
    object Amount : OnboardingScreenRoutes("amount")
    object Confirmation : OnboardingScreenRoutes("confirmation")
    object Payment : OnboardingScreenRoutes("payment")

}
@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(navController, startDestination = OnboardingScreenRoutes.Amount.route) {
        composable(OnboardingScreenRoutes.Amount.route) { AmountScreen(navController) }
        composable(OnboardingScreenRoutes.Confirmation.route) { ConfirmationScreen(navController) }
        composable(OnboardingScreenRoutes.Payment.route) { PaymentScreen(navController) }

    }
}