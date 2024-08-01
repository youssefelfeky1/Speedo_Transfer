package com.elfeky.speedo_transfer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.elfeky.speedo_transfer.ui.authentication.ExtendedSignUp
import com.elfeky.speedo_transfer.ui.authentication.SignIn
import com.elfeky.speedo_transfer.ui.authentication.SignUp
import com.elfeky.speedo_transfer.ui.main_screen.MainScreen
import com.elfeky.speedo_transfer.ui.on_boarding.OnboardingNavigation
import com.elfeky.speedo_transfer.ui.splash_screen.SplashScreen
import com.elfeky.speedo_transfer.util.Constants.EXTENDED_SIGN_UP
import com.elfeky.speedo_transfer.util.Constants.ONBOARD
import com.elfeky.speedo_transfer.util.Constants.SIGN_IN
import com.elfeky.speedo_transfer.util.Constants.SIGN_UP
import com.elfeky.speedo_transfer.util.Constants.SPLASH_SCREEN

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SPLASH_SCREEN) {
        composable(SPLASH_SCREEN) {
            SplashScreen(navController = navController)
        }
        composable(SIGN_UP) {
            SignUp(navController = navController)
        }
        composable(
            "$EXTENDED_SIGN_UP/{name}/{email}/{password}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType },
            ),
        ) {
            val name = it.arguments?.getString("name")!!
            val email = it.arguments?.getString("email")!!
            val password = it.arguments?.getString("password")!!
            ExtendedSignUp(
                name,
                email,
                password,
                navController = navController
            )
        }
        composable(SIGN_IN) {
            SignIn(navController = navController)
        }
        composable(ONBOARD) {
            val navController2 = rememberNavController()
            OnboardingNavigation(navController = navController2, navController)
        }
        composable("MainScreen") {
            MainScreen()
        }

    }
}