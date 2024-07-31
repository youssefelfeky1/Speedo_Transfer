package com.elfeky.speedo_transfer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavArgument
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
import com.elfeky.speedo_transfer.ui.on_boarding.OnboardingScreen
import com.elfeky.speedo_transfer.ui.splash_screen.SplashScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable("SplashScreen") {
            SplashScreen(navController = navController)
        }
        composable("SignUp") {
            SignUp(navController = navController)
        }
        composable(
            "ExtendedSignUp/{name}/{email}/{password}",
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
        composable("SignIn") {
            SignIn(navController = navController)
        }
        composable("Onboard") {
            val navController2 = rememberNavController()
            OnboardingNavigation(navController = navController2,navController)
        }
        composable("MainScreen"){
            MainScreen()
        }
    }
}