package com.elfeky.speedo_transfer.data.model

import androidx.annotation.DrawableRes

data class BottomNavigationItem(
    val title: String,
    @DrawableRes
    val selectedIcon: Int,
)