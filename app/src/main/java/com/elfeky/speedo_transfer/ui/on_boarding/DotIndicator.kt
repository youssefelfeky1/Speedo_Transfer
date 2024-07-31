package com.elfeky.speedo_transfer.ui.on_boarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.elfeky.speedo_transfer.ui.theme.DarkRed
import com.elfeky.speedo_transfer.ui.theme.RedP75

@Composable
fun DotIndicator(
    totalDots: Int,
    currentIndex: Int,
    activeColor: Color = DarkRed,
    inactiveColor: Color = RedP75
) {
    Row(
        modifier = Modifier
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        for (i in 0 until totalDots) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .background(
                        color = if (i == currentIndex) activeColor else inactiveColor,
                        shape = CircleShape
                    )

            )
        }
    }
}



