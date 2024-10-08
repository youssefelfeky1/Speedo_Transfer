package com.elfeky.speedo_transfer.navigation


import ConnectionScreen
import SelectCurrencyScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elfeky.speedo_transfer.R
import com.elfeky.speedo_transfer.data.model.BottomNavigationItem
import com.elfeky.speedo_transfer.ui.common.NotificationScreen
import com.elfeky.speedo_transfer.ui.main_screen.home.HomeScreen
import com.elfeky.speedo_transfer.ui.main_screen.more.MoreScreen
import com.elfeky.speedo_transfer.ui.main_screen.more.favourites.FavouriteScreen
import com.elfeky.speedo_transfer.ui.main_screen.more.profile.ProfileInformation
import com.elfeky.speedo_transfer.ui.main_screen.more.profile.ProfileScreen
import com.elfeky.speedo_transfer.ui.main_screen.more.profile.settings.ChangePassword
import com.elfeky.speedo_transfer.ui.main_screen.more.profile.settings.EditProfile
import com.elfeky.speedo_transfer.ui.main_screen.more.profile.settings.Setting
import com.elfeky.speedo_transfer.ui.main_screen.mycards.AccountConnectingScreen
import com.elfeky.speedo_transfer.ui.main_screen.mycards.AddCardsScreen
import com.elfeky.speedo_transfer.ui.main_screen.mycards.OTPScreen
import com.elfeky.speedo_transfer.ui.main_screen.transactions.TransactionDetailScreen
import com.elfeky.speedo_transfer.ui.main_screen.transactions.TransactionsScreen
import com.elfeky.speedo_transfer.ui.main_screen.transfer.TransferScreen
import com.elfeky.speedo_transfer.ui.theme.DarkRed
import com.elfeky.speedo_transfer.ui.theme.Gray
import com.elfeky.speedo_transfer.util.Constants.ACCOUNT_CONNECTING_SCREEN
import com.elfeky.speedo_transfer.util.Constants.ADD_CARDS
import com.elfeky.speedo_transfer.util.Constants.CHANGE_PASSWORD
import com.elfeky.speedo_transfer.util.Constants.CONNECTING
import com.elfeky.speedo_transfer.util.Constants.EDIT_PROFILE
import com.elfeky.speedo_transfer.util.Constants.FAVOURITES
import com.elfeky.speedo_transfer.util.Constants.HOME
import com.elfeky.speedo_transfer.util.Constants.MORE
import com.elfeky.speedo_transfer.util.Constants.MY_CARDS
import com.elfeky.speedo_transfer.util.Constants.NOTIFICATION_SCREEN
import com.elfeky.speedo_transfer.util.Constants.OTP
import com.elfeky.speedo_transfer.util.Constants.PROFILE
import com.elfeky.speedo_transfer.util.Constants.PROFILE_INFO
import com.elfeky.speedo_transfer.util.Constants.SETTINGS
import com.elfeky.speedo_transfer.util.Constants.TRANSACTIONS
import com.elfeky.speedo_transfer.util.Constants.TRANSACTION_DETAIL
import com.elfeky.speedo_transfer.util.Constants.TRANSFER

@Composable
fun MainNavigation(modifier: Modifier = Modifier , navHostController: NavController) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            MainNavigationBar(navController)
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = HOME,
        ) {
            composable(HOME) {
                HomeScreen(navController)
            }
            composable(TRANSFER) {
                TransferScreen(navController)
            }
            composable(TRANSACTIONS) {
                TransactionsScreen(navController)
            }
            composable(TRANSACTION_DETAIL) {
                TransactionDetailScreen(navController = navController)
            }
            composable(MY_CARDS) {
                SelectCurrencyScreen(navController)
            }
            composable(MORE) {
                MoreScreen(navController , navHostController)
            }
            composable(FAVOURITES) {
                FavouriteScreen(navController)
            }
            composable(PROFILE) {
                ProfileScreen(navController = navController)
            }
            composable(PROFILE_INFO) {
                ProfileInformation(navController = navController)
            }
            composable(SETTINGS) {
                Setting(navController = navController)
            }
            composable(CHANGE_PASSWORD)
            {
                ChangePassword(navController = navController)
            }
            composable(ADD_CARDS) {
                AddCardsScreen(navController)
            }
            composable(CONNECTING) {
                ConnectionScreen(navController)
            }
            composable(OTP) {
                OTPScreen(navController)
            }
            composable(ACCOUNT_CONNECTING_SCREEN) {
                AccountConnectingScreen(navController)
            }
            composable(EDIT_PROFILE) {
                EditProfile(navController = navController)
            }
            composable(NOTIFICATION_SCREEN){
                NotificationScreen(navController = navController)
            }



        }
    }
}


@Composable
fun MainNavigationBar(navController: NavController, modifier: Modifier = Modifier) {

    val navigationItems = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = R.drawable.home_1,
        ),
        BottomNavigationItem(
            title = "Transfer",
            selectedIcon = R.drawable.transfer_1,
        ),
        BottomNavigationItem(
            title = "Transactions",
            selectedIcon = R.drawable.history_1,
        ),
        BottomNavigationItem(
            title = "My cards",
            selectedIcon = R.drawable.cards_1,
        ),
        BottomNavigationItem(
            title = "More",
            selectedIcon = R.drawable.more_1,
        ),

        )

    var selectedItemIndex by remember {
        mutableStateOf(0)
    }

    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp))
            .background(Color.White),
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.title)
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 10.1.sp,
                        overflow = TextOverflow.Visible,
                        maxLines = 1,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White,
                    selectedIconColor = DarkRed,
                    unselectedIconColor = Gray,
                    selectedTextColor = DarkRed,
                    unselectedTextColor = Gray
                ),
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = item.selectedIcon),
                        contentDescription = item.title,
                    )
                },

                )
        }
    }
}
