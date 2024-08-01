package com.elfeky.speedo_transfer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.navigation.AppNavigation
import com.elfeky.speedo_transfer.ui.authentication.ExtendedSignUp
import com.elfeky.speedo_transfer.ui.on_boarding.OnboardingNavigation
import com.elfeky.speedo_transfer.ui.theme.Speedo_TransferTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Speedo_TransferTheme {
                AppNavigation()

            }
        }
    }
}

