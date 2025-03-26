package com.example.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

internal class NavigationState(val navHostController: NavHostController) {
    fun navigateTo(
        route: String,
        inclusive: Boolean = false,
        popUpToScreen: String = Screen.Main.route,
    ) {
        navHostController.navigate(route) {
            popUpTo(popUpToScreen) {
                this.inclusive = inclusive
            }
            launchSingleTop = true
        }
    }
}

@Composable
internal fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController)
    }
}