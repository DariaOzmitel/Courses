package com.example.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.ui.R

internal enum class BottomNavigationItem(
    val screen: Screen,
    @DrawableRes val iconResId: Int,
    @StringRes val titleResId: Int
) {
    Main(
        screen = Screen.Main,
        iconResId = R.drawable.menu_home,
        titleResId = R.string.main
    ),
    Favorite(
        screen = Screen.Favorite,
        iconResId = R.drawable.menu_bookmark,
        titleResId = R.string.favorite
    ),
    Account(
        screen = Screen.Account,
        iconResId = R.drawable.menu_profile,
        titleResId = R.string.account
    ),
}