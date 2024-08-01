package com.elfeky.speedo_transfer.ui.main_screen.transfer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.ui.main_screen.transfer.components.ProgressSection
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient
import com.elfeky.speedo_transfer.ui.theme.YellowTopGradient

@Composable
fun TransferScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(YellowTopGradient, RoseBottomGradient)
                )
            )
            .padding(16.dp)
        ,
    ) {
        val stageNumber = remember {
            mutableStateOf(1)
        }


        TransferTopAppBar {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(24.dp))
        ProgressSection(stageNumber = stageNumber)
        Spacer(modifier = Modifier.height(24.dp))




    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransferTopAppBar(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Transfer",
                    fontSize = 20.sp,
                    color = GrayG900,
                    fontWeight = FontWeight.Bold
                )
            }

        },
        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.drop_down_1),
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.Transparent)
    )
}

@Preview
@Composable
private fun TransferScreenPreview() {
    TransferScreen(navController = rememberNavController())
}