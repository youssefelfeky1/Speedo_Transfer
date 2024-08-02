package com.elfeky.speedo_transfer.ui.main_screen

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.elfeky.speedo_transfer.MainActivity
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.navigation.MainNavigation


@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    requestNotificationPermission(context)

    MainNavigation()
}

@SuppressLint("MissingPermission")
fun sendNotification(context: Context, title: String, text: String) {
    val builder = NotificationCompat.Builder(context, "1")
        .setSmallIcon(R.drawable.notifications_1)
        .setContentTitle(title)
        .setContentText(text)
        .setAutoCancel(true)

    NotificationManagerCompat.from(context).notify(99, builder.build())
}

private fun requestNotificationPermission(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val hasPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED

        if (!hasPermission) {
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                0
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MainNScreenPreview() {
    MainScreen()
}