package com.elfeky.speedo_transfer

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.elfeky.speedo_transfer.navigation.AppNavigation
import com.elfeky.speedo_transfer.ui.theme.Speedo_TransferTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        createNotificationChannel(this)
        setContent {
            Speedo_TransferTheme {
                AppNavigation()
            }
        }
    }

    private fun createNotificationChannel(context: Context) {
        val name = "Transactions"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel("1", name, importance)
        channel.description = "Successful Transactions"


        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}

