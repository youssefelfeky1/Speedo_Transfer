package com.elfeky.speedo_transfer.ui.main_screen.transfer.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.speedo_transfer.ui.theme.GrayG90
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.RedP300

@Composable
fun ProgressSection(modifier: Modifier = Modifier, stageNumber: MutableState<Int>) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            NumberedCircle(
                number = 1,
                circleColor = if (stageNumber.value >= 1) RedP300 else GrayG90,
                textColor = if (stageNumber.value >= 1) RedP300 else GrayG90
            )
            Canvas(modifier = Modifier) {
                drawLine(
                    color = if (stageNumber.value >= 1) RedP300 else GrayG90,
                    strokeWidth = 5f,
                    start = Offset(-100f, 0f),
                    end = Offset(100f, 0f)
                )
            }
            NumberedCircle(
                number = 2,
                circleColor = if (stageNumber.value >= 2) RedP300 else GrayG90,
                textColor = if (stageNumber.value >= 2) RedP300 else GrayG90
            )
            Canvas(modifier = Modifier) {
                drawLine(
                    color = if (stageNumber.value >= 2) RedP300 else GrayG90,
                    strokeWidth = 5f,
                    start = Offset(-100f, 0f),
                    end = Offset(100f, 0f)
                )
            }
            NumberedCircle(
                number = 3,
                circleColor = if (stageNumber.value >= 3) RedP300 else GrayG90,
                textColor = if (stageNumber.value >= 3) RedP300 else GrayG90
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Amount",
                fontWeight = if (stageNumber.value >= 1) FontWeight.Bold else FontWeight.Normal,
                fontSize = 14.sp,
                color = GrayG900
            )
            Text(
                text = "Confirmation",
                fontWeight = if (stageNumber.value >= 2) FontWeight.Bold else FontWeight.Normal,
                fontSize = 14.sp,
                color = GrayG900
            )
            Text(
                text = "Payment",
                fontWeight = if (stageNumber.value >= 3) FontWeight.Bold else FontWeight.Normal,
                fontSize = 14.sp,
                color = GrayG900
            )
        }
    }
}

@Composable
fun NumberedCircle(
    number: Int,
    circleColor: Color,
    textColor: Color,
    borderWidth: Dp = 2.dp,
    circleSize: Dp = 35.dp,
    textSize: TextUnit = 15.sp
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(circleSize)
            .clip(CircleShape)
            .background(Color.White)

    ) {
        Canvas(modifier = Modifier.size(circleSize).clip(CircleShape)) {
            drawCircle(
                color = circleColor,
                style = Stroke(width = borderWidth.toPx())
            )
        }
        Text(
            text = "0$number",
            style = TextStyle(
                color = textColor,
                fontSize = textSize,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
private fun ProgressSectionPreview() {
    ProgressSection(stageNumber = mutableStateOf(1))
}