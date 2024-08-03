package com.elfeky.speedo_transfer.ui.main_screen.transfer

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.elfeky.speedo_transfer.ui.main_screen.transfer.components.AmountSection
import com.elfeky.speedo_transfer.ui.main_screen.transfer.components.ConfirmationSection
import com.elfeky.speedo_transfer.ui.main_screen.transfer.components.FavouriteBottomSheet
import com.elfeky.speedo_transfer.ui.main_screen.transfer.components.PaymentSection
import com.elfeky.speedo_transfer.ui.main_screen.transfer.components.ProgressSection
import com.elfeky.speedo_transfer.ui.theme.GrayG900
import com.elfeky.speedo_transfer.ui.theme.RedP300
import com.elfeky.speedo_transfer.ui.theme.RoseBottomGradient
import com.elfeky.speedo_transfer.ui.theme.YellowTopGradient
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun TransferScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: TransferViewModel = viewModel()
) {
    val stageNumber = remember {
        mutableStateOf(1)
    }
    val amount = remember {
        mutableStateOf("")
    }
    val recipientName = remember {
        mutableStateOf("")
    }
    val recipientAccount = remember {
        mutableStateOf("")
    }
    val showBottomSheet = remember {
        mutableStateOf(false)
    }
    val favoriteRecipients by viewModel.selectAllRecipients().collectAsState(initial = emptyList())

    val sheetState = rememberModalBottomSheetState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(YellowTopGradient, RoseBottomGradient)
                )
            )
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        MainTopAppBar(title = "Transfer") {
            if (stageNumber.value == 1) {
                navController.popBackStack()
            } else if (stageNumber.value == 3) {
                stageNumber.value = 1
                amount.value = ""
                recipientName.value = ""
                recipientAccount.value = ""
            } else {
                stageNumber.value -= 1
            }

        }
        Spacer(modifier = Modifier.height(24.dp))
        ProgressSection(stageNumber = stageNumber)
        Spacer(modifier = Modifier.height(24.dp))
        when (stageNumber.value) {
            1 -> {
                AmountSection(
                    amount = amount,
                    recipientName = recipientName,
                    recipientAccount = recipientAccount,
                    onContinue = {
                        stageNumber.value += 1
                    },
                    showBottomSheet = showBottomSheet
                )
            }

            2 -> {
                ConfirmationSection(
                    amount = amount,
                    recipientName = recipientName,
                    recipientAccount = recipientAccount,
                    stageNumber = stageNumber
                )
            }

            3 -> {
                PaymentSection(
                    amount = amount,
                    recipientName = recipientName,
                    recipientAccount = recipientAccount,
                    stageNumber = stageNumber,
                    navController = navController
                )
            }
        }

        Spacer(modifier = Modifier.height(120.dp))
    }

    if (showBottomSheet.value) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet.value = false },
            sheetState = sheetState
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.favorite_1),
                    contentDescription = "Favourite",
                    tint = RedP300,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .size(20.dp)
                )
                Text(
                    text = "Favourite List",
                    fontSize = 20.sp,
                    color = RedP300,
                    modifier = Modifier.padding(end = 4.dp)
                )
            }

            FavouriteBottomSheet(
                favouriteRecipients = favoriteRecipients,
                onItemClick = {
                    recipientName.value = it.recipientName
                    recipientAccount.value = it.recipientAccount
                    showBottomSheet.value = false
                }
            )
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(modifier: Modifier = Modifier, title:String, onBackClick: () -> Unit) {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
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

@Preview(showBackground = true)
@Composable
private fun TransferScreenPreview() {
    TransferScreen(navController = rememberNavController())
}